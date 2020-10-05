package main

import "fmt"

const MaxNumber = 1000

func main() {
	var multiples []int //explicitly keep multiples - just because we can =^_^=

	for i := 1; i < MaxNumber; i++ {
		if isMultipleOfThreeOrFive(i) {
			multiples = append(multiples, i)
		}
	}

	sum := 0
	for _, value := range multiples {
		sum += value
	}

	fmt.Print(sum)
}

func isMultipleOfThreeOrFive(num int) bool {
	return num%3 == 0 || num%5 == 0
}
