package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(countBits(2), []int{0, 1, 1})
	assert(countBits(5), []int{0, 1, 1, 2, 1, 2})
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func countBits(num int) []int {
	result := make([]int, num+1)

	offset := 1
	for index := 1; index <= num; index++ {
		if offset*2 == index {
			offset *= 2
		}

		result[index] = result[index-offset] + 1
	}

	return result
}
