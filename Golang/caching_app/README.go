movie.go is a database of the top 10 movies of all time as per IMDB.

main.go generates a random number between 1 and 10. 
Based on this number, the movie with the given rank is displayed. 
This random generation of number between 1 and 10 occurs 10 times. 
If a certain rank is queried for the first time, it picks the data from the database. This data is also cached, which is where the data is pulled from if the same rank is queried again.

To run the code - 
$ go run .
