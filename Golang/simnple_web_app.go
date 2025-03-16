package main

import (
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/", index_handler)
	http.HandleFunc("/about/", about_handler)
	http.ListenAndServe(":8000", nil)
}

func index_handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "<h1>Go web app - home page</h1>")
	fmt.Fprintf(w, "As simple as that - don't even have html tags")
}

func about_handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "<h1>Go web app - about page</h1>")
	fmt.Fprint(w, `<p>Here, you'll see multiple lines</p>
	<p>2nd line just to prove the point</p>
	<p>3rd line for no reason</p>`)
}

// Ensure port 8000 is open and check the below pages -
// http://127.0.0.1:8000/
// http://127.0.0.1:8000/about/
