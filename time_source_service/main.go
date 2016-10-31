package main

import (
	"fmt"
	"net/http"
	"os"
	"time"
	"runtime"
)

func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Printf("%s %s %s %s (%s)\n", r.Method, r.URL, r.Proto, r.RemoteAddr, r.UserAgent())
	hostname, _ := os.Hostname()
	fmt.Fprintf(w, "{ \"time\": \"%d\", \"hostname\": \"%s\", \"runtime\": \"%s\" }", time.Now().Unix(), hostname, runtime.Version())
	w.Header().Set("Content-Type", "application/json")
}

func main() {
	fmt.Println("Started time_source_service...")
	http.HandleFunc("/", handler)
	http.ListenAndServe(":8080", nil)
}
