package main

import (
	"fmt"
)

func main() {
	assert(findComplement(2), 1)
	assert(findComplement(5), 2)
	assert(findComplement(1), 0)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func findComplement(num int) int {
	closestPowerOf2 := 1
	for i := 1; i <= num; i = i << 1 {
		closestPowerOf2 = i
	}

	return (closestPowerOf2<<1 - 1) - num
}
