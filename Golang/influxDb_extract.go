package main

/*
This script has to be run before setting Patroni for any given servers.
It checks if the configurations and server details match between the East and Central servers
Also checks if there are existing Clusters with the same name you're trying to setup.
Arguments to be provided from the command line:
c --> Central Hostname
e --> East Hostname
cluster --> Cluster Name
For example:
go run patroniPreChecks.go -c cxxx12345 -e exxx12345 -cluster myDB
*/

import (
	"database/sql"
	"encoding/json"
	"errors"
	"flag"
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
	"os"
	"strings"

	"github.com/jedib0t/go-pretty/table"
	_ "github.com/lib/pq"
)

const (
	url  = "https://xxxxinfluxxxxx-postgres.example.com/query?q="
	pg_port = 5432
	pg_user = "userID"
	pg_pass = "REDACTED"
	pg_ssl  = "require"
)

type PullMetrics struct {
	Results []Results
}

type Results struct {
	Series []Series
}

type Series struct {
	Name    string
	Tags    map[string]string
	Columns []string
	Values  [][]interface{}
}

type CurrentObjects struct {
	TableCatalog string
	TableName    string
	TableType    string
}

func queryInflux(qry string) ([]byte, error) {
	resp, err := http.Get(url + url.QueryEscape(qry))
	if err != nil {
		fmt.Printf("ERROR: Unable to run %v. %v\n", qry, err)
		return nil, errors.New("Unable to query from Influx: " + qry)
	} else {
		data, _ := ioutil.ReadAll(resp.Body)
		return data, nil
	}
}

func getComplianceType(cmpl string) string {
	switch {
	case cmpl == "0":
		return "None"
	case cmpl == "1":
		return "ComplianceType1"
	case cmpl == "2":
		return "ComplianceType2"
	case cmpl == "3":
		return "ComplianceType3"
	case cmpl == "4":
		return "ComplianceType4"
	default:
		return "Unknown"
	}
}


func getDBTables(node string, dbname string) ([]CurrentObjects, error) {
	dbQry := "select distinct table_catalog, table_schema||'.'||table_name as table_name, table_type from information_schema.tables where table_schema not in (<<excludeList>>) and table_name not in (<<excludeList>>);"
	conn := fmt.Sprintf("host=%s port=%d user=%s password=%s dbname=%s sslmode=%s", node, pg_port, pg_user, pg_pass, dbname, pg_ssl)
	db, err := sql.Open("postgres", conn)
	if err != nil {
		return nil, err
	}
	rows, err := db.Query(dbQry)
	if err != nil {
		return nil, err
	}
	defer db.Close()
	defer rows.Close()
	rcrds := make([]CurrentObjects, 0)
	for rows.Next() {
		rcrd := CurrentObjects{}
		err := rows.Scan(&rcrd.TableCatalog, &rcrd.TableName, &rcrd.TableType)
		if err != nil {
			fmt.Println(err)
		}
		rcrds = append(rcrds, rcrd)
	}
	return rcrds, nil
}

func main() {
	// Parsing arguments
	c_srvr := flag.String("c", "Central_Host", "Postgres Host in Central")
	e_srvr := flag.String("e", "East_Host", "Postgres Host in East")
	cluster_name := flag.String("cluster", "cluster", "Cluster name for Patroni")
	flag.Parse()
	c := strings.ToLower(*c_srvr)
	e := strings.ToLower(*e_srvr)
	cluster := strings.ToLower(*cluster_name)

	// Queries for InfluxDB
	where := fmt.Sprintf("WHERE host =~ /%v|%v/ and time >= now()-5m", c, e)
	qry_rgn_dbnm_env_ci := fmt.Sprintf("SELECT last(out) FROM someTable1 %v GROUP BY host, owner_application_ci, region, db_name, environment", where)
	qry_ver_maxconn := fmt.Sprintf("SELECT  last(ver), last(max_connections) FROM \"some-Table2\" %v GROUP BY host", where)
	qry_cmpl := fmt.Sprintf("SELECT last(regulated) FROM someTable3 %v GROUP BY host", where)
	qry_patroni := fmt.Sprintf("SELECT last(havepatroni) FROM someTable4 %v GROUP BY host", where)
	qry_cpu := fmt.Sprintf("SELECT last(n_cpus) FROM someTable5 %v GROUP BY host", where)
	qry_mem := fmt.Sprintf("SELECT last(total) FROM someTable6 %v GROUP BY host", where)
	qry_disk := fmt.Sprintf("SELECT last(used), last(total) FROM someTable7 %v GROUP BY host", where)

	// Used to render final output
	central_srvr := make(map[string]string)
	east_srvr := make(map[string]string)

	fmt.Print("***** Gathering info - Region, DB Name, Environment, application ID")
	data_rgn_dbnm_env_ci := PullMetrics{}
	bytes_rgn_dbnm_env_ci, err := queryInflux(qry_rgn_dbnm_env_ci)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_rgn_dbnm_env_ci, &data_rgn_dbnm_env_ci)
	}
	values_rgn_dbnm_env_ci := data_rgn_dbnm_env_ci.Results[0].Series
	for _, v := range values_rgn_dbnm_env_ci {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			central_srvr["db_name"] = string(v.Tags["db_name"])
			central_srvr["environment"] = string(v.Tags["environment"])
			central_srvr["application_id"] = string(v.Tags["owner_application_ci"])
			central_srvr["region"] = string(v.Tags["region"])
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			east_srvr["db_name"] = string(v.Tags["db_name"])
			east_srvr["environment"] = string(v.Tags["environment"])
			east_srvr["application_id"] = string(v.Tags["owner_application_ci"])
			east_srvr["region"] = string(v.Tags["region"])
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Print(", Version, Max Connections")
	data_ver_maxconn := PullMetrics{}
	bytes_ver_maxconn, err := queryInflux(qry_ver_maxconn)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_ver_maxconn, &data_ver_maxconn)
	}
	values_ver_maxconn := data_ver_maxconn.Results[0].Series
	for _, v := range values_ver_maxconn {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			central_srvr["version"] = fmt.Sprint(v.Values[0][1])
			central_srvr["max_connections"] = fmt.Sprint(v.Values[0][2])
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			east_srvr["version"] = fmt.Sprint(v.Values[0][1])
			east_srvr["max_connections"] = fmt.Sprint(v.Values[0][2])
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Print(", Compliance Type")
	data_cmpl := PullMetrics{}
	bytes_cmpl, err := queryInflux(qry_cmpl)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_cmpl, &data_cmpl)
	}
	values_cmpl := data_cmpl.Results[0].Series
	for _, v := range values_cmpl {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			central_srvr["compliance"] = getComplianceType(fmt.Sprint(v.Values[0][1]))
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			east_srvr["compliance"] = getComplianceType(fmt.Sprint(v.Values[0][1]))
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Print(", Patroni info")
	data_patroni := PullMetrics{}
	bytes_patroni, err := queryInflux(qry_patroni)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_patroni, &data_patroni)
	}
	values_patroni := data_patroni.Results[0].Series
	for _, v := range values_patroni {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			if fmt.Sprint(v.Values[0][1]) == "1" {
				central_srvr["patroni_already"] = "Yes"
			} else if fmt.Sprint(v.Values[0][1]) == "0" {
				central_srvr["patroni_already"] = "No"
			} else {
				central_srvr["patroni_already"] = "Unknown"
			}
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			if fmt.Sprint(v.Values[0][1]) == "1" {
				east_srvr["patroni_already"] = "Yes"
			} else if fmt.Sprint(v.Values[0][1]) == "0" {
				east_srvr["patroni_already"] = "No"
			} else {
				east_srvr["patroni_already"] = "Unknown"
			}
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Print(", CPU")
	data_cpu := PullMetrics{}
	bytes_cpu, err := queryInflux(qry_cpu)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_cpu, &data_cpu)
	}
	values_cpu := data_cpu.Results[0].Series
	for _, v := range values_cpu {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			cpuCount := fmt.Sprint(v.Values[0][1].(float64))
			central_srvr["cpu"] = cpuCount
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			cpuCount := fmt.Sprint(v.Values[0][1].(float64))
			east_srvr["cpu"] = cpuCount
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Print(", Memory")
	data_mem := PullMetrics{}
	bytes_mem, err := queryInflux(qry_mem)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_mem, &data_mem)
	}
	values_mem := data_mem.Results[0].Series
	for _, v := range values_mem {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			memGB := fmt.Sprintf("%.2f", (v.Values[0][1].(float64) / 1e+9))
			central_srvr["memory"] = memGB + " GB"
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			memGB := fmt.Sprintf("%.2f", (v.Values[0][1].(float64) / 1e+9))
			east_srvr["memory"] = memGB + " GB"
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Println(", Disk")
	data_disk := PullMetrics{}
	bytes_disk, err := queryInflux(qry_disk)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_disk, &data_disk)
	}
	values_disk := data_disk.Results[0].Series
	for _, v := range values_disk {
		if strings.HasPrefix(v.Tags["host"], "cxxxx") {
			central_srvr["host"] = string(v.Tags["host"])
			usedGB := fmt.Sprintf("%.2f", (v.Values[0][1].(float64) / 1e+9))
			central_srvr["diskUsed"] = usedGB + " GB"
			totalGB := fmt.Sprintf("%.2f", (v.Values[0][2].(float64) / 1e+9))
			central_srvr["diskTotal"] = totalGB + " GB"
		} else if strings.HasPrefix(v.Tags["host"], "exxxx") {
			east_srvr["host"] = string(v.Tags["host"])
			usedGB := fmt.Sprintf("%.2f", (v.Values[0][1].(float64) / 1e+9))
			east_srvr["diskUsed"] = usedGB + " GB"
			totalGB := fmt.Sprintf("%.2f", (v.Values[0][2].(float64) / 1e+9))
			east_srvr["diskTotal"] = totalGB + " GB"
		} else {
			fmt.Println("Error reading data")
		}
	}

	fmt.Println("\nBasic server info - Hard stop if these values don't match")
	fmt.Println("-------------------------------------------------------------------------------")
	t1 := table.NewWriter()
	t1.SetOutputMirror(os.Stdout)
	t1.AppendHeader(table.Row{"Host", "application ID", "DB Name", "Environment", "Version", "Compliance", "Patroni already"})
	t1.AppendRows([]table.Row{{central_srvr["host"],
		central_srvr["application_id"],
		central_srvr["db_name"],
		central_srvr["environment"],
		central_srvr["version"],
		// central_srvr["region"],
		central_srvr["compliance"],
		central_srvr["patroni_already"]}})
	t1.AppendRows([]table.Row{{east_srvr["host"],
		east_srvr["application_id"],
		east_srvr["db_name"],
		east_srvr["environment"],
		east_srvr["version"],
		// east_srvr["region"],
		east_srvr["compliance"],
		east_srvr["patroni_already"]}})
	t1.SetStyle(table.StyleLight)
	t1.Render()

	fmt.Println("\nServer configurations - Sync configs before proceeding")
	fmt.Println("-------------------------------------------------------------------------------")
	t2 := table.NewWriter()
	t2.SetOutputMirror(os.Stdout)
	t2.AppendHeader(table.Row{"Host", "CPU Count", "Memory", "Disk Total", "Disk Used", "Max Connections"})
	t2.AppendRows([]table.Row{{central_srvr["host"],
		central_srvr["cpu"],
		central_srvr["memory"],
		central_srvr["diskTotal"],
		central_srvr["diskUsed"],
		central_srvr["max_connections"]}})
	t2.AppendRows([]table.Row{{east_srvr["host"],
		east_srvr["cpu"],
		east_srvr["memory"],
		east_srvr["diskTotal"],
		east_srvr["diskUsed"],
		east_srvr["max_connections"]}})
	t2.SetStyle(table.StyleLight)
	t2.Render()

	fmt.Println("\n***** Checking current Patroni clusters")
	fmt.Println("-------------------------------------------------------------------------------")
	// Additional step added to ensure the Cluster name doesn't already exist for different hosts.
	// This is to avoid accidentally adding nodes to an existing cluster
	qry_cluster := fmt.Sprintf("SELECT last(havepatroni) FROM someTable8 WHERE pcluster = '%v' and time >= now() - 5m GROUP BY host, pcluster", cluster)
	data_cluster := PullMetrics{}
	bytes_cluster, err := queryInflux(qry_cluster)
	if err != nil {
		fmt.Printf("ERROR: %v\n", err)
	} else {
		json.Unmarshal(bytes_cluster, &data_cluster)
	}
	if len(data_cluster.Results[0].Series) == 0 {
		fmt.Printf("There are no existing clusters with the name %v. Proceed.\n", cluster)
	} else if len(data_cluster.Results[0].Series) > 0 {
		fmt.Printf("There is an existing cluster with the name '%v' with the below hosts.\n", cluster)
		fmt.Println("You can proceed if they're of different Version and Environment")
		for _, v := range data_cluster.Results[0].Series {
			fmt.Printf(" * %v\n", v.Tags["host"])
		}
	} else {
		fmt.Println("Problem checking for existing clusters")
	}

	// Checking for DB objects.
	// To be used particularly when converting existing stand alone nodes to Patroni
	var centraltbls, easttbls string
	if strings.ToLower(central_srvr["db_name"]) == strings.ToLower(east_srvr["db_name"]) {
		fmt.Println("\n***** Checking for existing tables in the DB")
		fmt.Println("-------------------------------------------------------------------------------")
		fmt.Println("In case you're converting a stand-alone node to Patroni, the current existing node should be set as the leader")
		centralTables, err_central := getDBTables(strings.ToLower(central_srvr["host"]), strings.ToLower(central_srvr["db_name"]))
		if err_central != nil {
			fmt.Printf("ERROR: Unable to fetch info from central server: %v\n", err_central)
		} else {
			if len(centralTables) != 0 {
				for _, tbl := range centralTables {
					centraltbls += fmt.Sprintf("%v\n", tbl.TableName)
				}
			}
		}
		eastTables, err_east := getDBTables(strings.ToLower(east_srvr["host"]), strings.ToLower(east_srvr["db_name"]))
		if err_east != nil {
			fmt.Printf("ERROR: Unable to fetch info from east server: %v\n", err_east)

		} else {
			if len(eastTables) != 0 {
				for _, tbl := range eastTables {
					easttbls += fmt.Sprintf("%v\n", tbl.TableName)
				}
			}
		}
	} else {
		fmt.Println("\n***** DB Names don't match between nodes. \nDO NOT SETUP PATRONI ON THESE NODES.\n")
		fmt.Println("-------------------------------------------------------------------------------")
	}
	t3 := table.NewWriter()
	t3.SetOutputMirror(os.Stdout)
	t3.AppendHeader(table.Row{"Host", "Existing Tables"})
	t3.AppendRows([]table.Row{{central_srvr["host"], centraltbls}})
	t3.AppendRows([]table.Row{{"----------", "--------------------"}})
	t3.AppendRows([]table.Row{{east_srvr["host"], easttbls}})
	t3.SetStyle(table.StyleLight)
	t3.Render()

}
