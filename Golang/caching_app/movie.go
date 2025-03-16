package main

import "fmt"

type Movie struct {
	Rank   int
	Title  string
	Rating float64
	Year   int
}

func (m Movie) String() string {
	return fmt.Sprintf(
		"Title:\t\t%q\n"+
			"Rating:\t\t%v\n"+
			"Released:\t%v\n", m.Title, m.Rating, m.Year)
}

var movies = []Movie{
	Movie{
		Rank:   1,
		Title:  "The Shawshank Redemption",
		Rating: 9.2,
		Year:   1994,
	},
	Movie{
		Rank:   2,
		Title:  "The Godfather",
		Rating: 9.1,
		Year:   1972,
	},
	Movie{
		Rank:   3,
		Title:  "The Godfather: Part II",
		Rating: 9.0,
		Year:   1974,
	},
	Movie{
		Rank:   4,
		Title:  "The Dark Knight",
		Rating: 9.0,
		Year:   2008,
	},
	Movie{
		Rank:   5,
		Title:  "12 Angry Men",
		Rating: 8.9,
		Year:   1957,
	},
	Movie{
		Rank:   6,
		Title:  "Schindler's List",
		Rating: 8.9,
		Year:   1993,
	},
	Movie{
		Rank:   7,
		Title:  "The Lord of the Rings: The Return of the King",
		Rating: 8.9,
		Year:   2003,
	},
	Movie{
		Rank:   8,
		Title:  "Pulp Fiction",
		Rating: 8.8,
		Year:   1994,
	},
	Movie{
		Rank:   9,
		Title:  "The Good, the Bad and the Ugly",
		Rating: 8.8,
		Year:   1966,
	},
	Movie{
		Rank:   10,
		Title:  "The Lord of the Rings: The Fellowship of the Ring",
		Rating: 8.8,
		Year:   2001,
	},
}
