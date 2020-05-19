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

type Entry struct {
	price int
	span  int
}

type StockSpanner struct {
	entries []Entry
}

func Constructor() StockSpanner {
	return StockSpanner{}
}

//lack of stack oob is great
func (s *StockSpanner) Next(price int) int {
	span := 1

	for len(s.entries) > 0 && price >= s.entries[len(s.entries)-1].price {
		lastIndex := len(s.entries) - 1

		entry := s.entries[lastIndex]
		span += entry.span
		s.entries = s.entries[:lastIndex]
	}

	s.entries = append(s.entries, Entry{
		price: price,
		span:  span,
	})

	return span
}
