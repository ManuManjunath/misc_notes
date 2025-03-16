package main

import (
	"fmt"
	"math/rand"
	"time"
)

var cache = map[int]Movie{}
var rnd = rand.New(rand.NewSource(time.Now().UnixNano()))

func main() {
	for i := 0; i < 10; i++ {
		rank := rnd.Intn(10) + 1
		if m, ok := queryCache(rank); ok {
			fmt.Println("from cache")
			fmt.Println(m)
			continue
		}
		if m, ok := queryDatabase(rank); ok {
			fmt.Println("from database")
			fmt.Println(m)
			continue
		}

		fmt.Println("Movie not in top 10")
		time.Sleep(150 * time.Millisecond)
	}
}

func queryCache(rank int) (Movie, bool) {
	m, ok := cache[rank]
	return m, ok
}

func queryDatabase(rank int) (Movie, bool) {
	time.Sleep(100 * time.Millisecond)
	for _, m := range movies {
		if m.Rank == rank {
			cache[rank] = m
			return m, true
		}
	}

	return Movie{}, false
}
