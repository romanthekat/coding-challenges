package main

import "fmt"

func main() {
	spanner := Constructor()
	assert(spanner.Next(100), 1)
	assert(spanner.Next(80), 1)
	assert(spanner.Next(60), 1)
	assert(spanner.Next(70), 2)
	assert(spanner.Next(60), 1)
	assert(spanner.Next(75), 4)
	assert(spanner.Next(85), 6)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

const (
	up = iota
	down
	same
)

type Trend int

type Entry struct {
	price      int
	trend      Trend
	startIndex int
}

type StockSpanner struct {
	entries []Entry
}

func Constructor() StockSpanner {
	return StockSpanner{}
}

func (s *StockSpanner) Next(price int) int {
	if len(s.entries) == 0 {
		s.entries = append(s.entries, Entry{
			price:      price,
			trend:      same,
			startIndex: 0,
		})
		return 1
	}

	prevEntry := s.entries[len(s.entries)-1]

	prevTrend := prevEntry.trend

	if (prevTrend == up && prevEntry.price < price) ||
		(prevTrend == down && prevEntry.price > price) ||
		(prevTrend == same && prevEntry.price == price) {
		s.entries = append(s.entries, Entry{
			price:      price,
			trend:      prevTrend,
			startIndex: prevEntry.startIndex,
		})
	} else {
		var trend Trend = same
		if prevEntry.price > price {
			trend = down
		} else if prevEntry.price < price {
			trend = up
		}

		s.entries = append(s.entries, Entry{
			price:      price,
			trend:      trend,
			startIndex: len(s.entries) - 1,
		})
	}

	return getSpan(s, len(s.entries)-1)
}

func getSpan(s *StockSpanner, index int) int {
	entry := s.entries[index]
	if entry.startIndex == index {
		return 1
	}

	if entry.trend == same || entry.trend == up {
		return index - entry.startIndex + 1
	}

	return 1
}
