package main
/*
import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

var cache = map[int]Movie{}
var rnd = rand.New(rand.NewSource(time.Now().UnixNano()))

func main() {
	wg := &sync.WaitGroup{}
	mt := &sync.RWMutex{}
	cacheCh := make(chan Movie)
	dbCh := make(chan Movie)

	for i := 0; i < 10; i++ {
		rank := rnd.Intn(10) + 1
		wg.Add(2)
		go func(rank int, wg *sync.WaitGroup, mt *sync.RWMutex, ch chan<- Movie) {
			if m, ok := queryCache(rank, mt); ok {
				ch <- m
			}
			wg.Done()
		}(rank, wg, mt, cacheCh)
		go func(rank int, wg *sync.WaitGroup, mt *sync.RWMutex, ch chan<- Movie) {
			if m, ok := queryDatabase(rank, mt); ok {
				mt.Lock()
				cache[rank] = m
				mt.Unlock()
				ch <- m
			}
			wg.Done()
		}(rank, wg, mt, dbCh)

		// create one goroutine per query to handle response
		go func(cacheCh, dbCh <-chan Movie) {
			select {
			case m := <-cacheCh:
				fmt.Println("from cache")
				fmt.Println(m)
				<-dbCh
			case m := <-dbCh:
				fmt.Println("from database")
				fmt.Println(m)
			}
		}(cacheCh, dbCh)
		time.Sleep(150 * time.Millisecond)
	}
	wg.Wait()
}

func queryCache(rank int, mt *sync.RWMutex) (Movie, bool) {
	mt.RLock()
	m, ok := cache[rank]
	mt.RUnlock()
	return m, ok
}

func queryDatabase(rank int, mt *sync.RWMutex) (Movie, bool) {
	time.Sleep(100 * time.Millisecond)
	for _, m := range movies {
		if m.Rank == rank {
			mt.Lock()
			cache[rank] = m
			mt.Unlock()
			return m, true
		}
	}

	return Movie{}, false
}
*/
