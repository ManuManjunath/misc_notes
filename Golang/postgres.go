package main

import (
	"database/sql"
	"fmt"
	"net/http"

	_ "github.com/lib/pq"
)

const (
	pg_host   = ""
	pg_port   = 5432
	pg_user   = ""
	pg_pass   = ""
	pg_dbname = ""
	pg_ssl    = "require"
)

type Columns struct {
	Host    string
	blossom string
	ver     string
	db_name string
	env     string
	region  string
}

func init() {
	pg_conn_str := fmt.Sprintf("host=%s port=%d user=%s password=%s dbname=%s, sslmode=%s", pg_host, pg_port, pg_user, pg_pass, pg_dbname, pg_ssl)
	db, err := sql.Open("postgres", pg_conn_str)
	if err != nil {
		fmt.Println("ERROR: Error connecting to the DB %v", err)
	}
	defer db.Close()
	if err = db.Ping(); err != nil {
		fmt.Println("Can't ping!! Why %v", err)
	}

}

func main() {
	http.HandleFunc("/static", static_handler)
	http.HandleFunc("/second_page", second_page_handler)
	http.ListenAndServe(":8080", nil)
}

func static_handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "<h1>Hello from static page!</h>")
}

func second_page_handler(w http.ResponseWriter, r *http.Request) {
	// GET only
	if r.Method != "GET" {
		http.Error(w, http.StatusText(500), http.StatusMethodNotAllowed)
		return
	}

	rows, err := db.Query(`select * from "some_table" where "Host" = 'abcd'`)
	if err != nil {
		http.Error(w, http.StatusText(500), http.StatusInternalServerError)
		return
	}
	defer rows.Close()

	rcrds := make([]Columns, 0)
	for rows.Next() {
		rcrd := Columns{}
		err := rows.Scan(&rcrd.Host, &rcrd.blossom, &rcrd.ver, &rcrd.db_name, &rcrd.env, &rcrd.region)
		if err != nil {
			fmt.Fprintf(w, err)
			http.Error(w, http.StatusText(500), 500)
			return
		}
		rcrds = append(rcrds, rcrd)
	}

	if err = rows.Err(); err != nil {
		http.Error(w, http.StatusText(500), 500)
		return
	}

	for _, rcrd := range rcrds {
		fmt.Fprintf(w, "%v, %v, %v, %v, %v, %v \n", rcrd.Host, rcrd.id, rcrd.ver, rcrd.db_name, rcrd.env, rcrd.region)
	}
}
