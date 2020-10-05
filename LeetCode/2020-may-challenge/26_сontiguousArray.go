package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(findMaxLength([]int{0, 1}), 2)
	assert(findMaxLength([]int{1, 0}), 2)
	assert(findMaxLength([]int{0, 1, 0}), 2)
	assert(findMaxLength([]int{0, 1, 0, 1, 0, 0}), 4)
	assert(findMaxLength([]int{0, 0, 1, 0, 0, 0, 1, 1}), 6)
	assert(findMaxLength([]int{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1}), 94)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func findMaxLength(nums []int) int {
	count := 0
	maxLength := 0
	memo := map[int]int{0: -1}

	for index, value := range nums {
		if value == 0 {
			count--
		} else {
			count++
		}

		if memoValue, ok := memo[count]; ok {
			maxLength = max(maxLength, index-memoValue)
		} else {
			memo[count] = index
		}
	}

	return maxLength
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
