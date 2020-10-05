package main

import "fmt"

const MaxFibonacciValue = 4000000

func main() {
	sum := 0

	fibonacci := fibonacciGenerator{}
	fibonacci.init()

	for {
		fibonacciValue := fibonacci.next()
		if fibonacciValue > MaxFibonacciValue {
			break
		}

		if isEven(fibonacciValue) {
			sum += fibonacciValue
		}
	}

	fmt.Print(sum)
}

type fibonacciGenerator struct {
	currValue, prevValue int
}

func (f *fibonacciGenerator) next() int {
	newValue := f.currValue + f.prevValue

	f.prevValue = f.currValue
	f.currValue = newValue

	return newValue
}

func (f *fibonacciGenerator) init() {
	f.currValue = 1
}

func isEven(num int) bool {
	return num%2 == 0
}
