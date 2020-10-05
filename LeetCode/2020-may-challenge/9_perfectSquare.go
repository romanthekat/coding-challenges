package main

import (
	"fmt"
)

func main() {
	assert(isPerfectSquare(16), true)
	assert(isPerfectSquare(14), false)
	assert(isPerfectSquare(2147483647), false)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

//alternatively: newton method
//sqrt is not linear, so binary search can be adjusted from /2
func isPerfectSquare(num int) bool {
	min := 1
	max := num

	for min < max {
		toCheck := min + (max-min)/2 //(min + max) / 2

		if num/toCheck > toCheck {
			min = toCheck + 1
		} else {
			max = toCheck
		}
	}

	if isSquare(num, min) || isSquare(num, max) {
		return true
	} else {
		return false
	}
}

func isSquare(num int, squareRoot int) bool {
	return (num%squareRoot == 0) && (num/squareRoot == squareRoot)
}
