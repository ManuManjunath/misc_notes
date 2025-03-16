package main

import (
	"encoding/json"
	"fmt"
	"os"
)

type jsonTest struct {
	Name  string
	Email string
	Multi []string
}

func main() {
	fmt.Println("Lets see if this works")

	file, _ := os.Open("json_sample.json")
	defer file.Close()
	decoder := json.NewDecoder(file)
	conf := jsonTest{}
	err := decoder.Decode(&conf)
	if err != nil {
		fmt.Println("error: ", err)
	}
	fmt.Println(conf.Name)
	fmt.Println(conf.Email)
	fmt.Println(conf.Multi)

}
