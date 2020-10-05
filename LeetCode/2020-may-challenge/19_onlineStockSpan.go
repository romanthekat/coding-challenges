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
	stack []*Entry
}

func Constructor() StockSpanner {
	return StockSpanner{}
}

//lack of stack oob is great
func (s *StockSpanner) Next(price int) int {
	span := 1

	for len(s.stack) > 0 && price >= s.stack[len(s.stack)-1].price {
		lastIndex := len(s.stack) - 1

		top := s.stack[lastIndex]
		span += top.span
		s.stack = s.stack[:lastIndex]
	}

	s.stack = append(s.stack, &Entry{
		price: price,
		span:  span,
	})

	return span
}
