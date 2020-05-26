package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(findMaxLength([]int{0, 1}), 2)
	assert(findMaxLength([]int{0, 1, 0}), 2)
	assert(findMaxLength([]int{0, 1, 0, 1, 0, 0}), 4)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func findMaxLength(nums []int) int {
	return findMaxLengthRecursive(nums, 0, len(nums), 0)
}

func findMaxLengthRecursive(nums []int, from, to int, currMax int) int {
	if from < 0 || from > to {
		return currMax
	}

	if isContiguousArray(nums[from:to]) {
		if len(nums[from:to]) < currMax {
			return currMax
		} else {
			currMax = len(nums[from:to])
		}
	}

	return max(findMaxLengthRecursive(nums, from-1, to, currMax), findMaxLengthRecursive(nums, from, to-1, currMax))
}

func isContiguousArray(nums []int) bool {
	zeroes := 0
	ones := 0

	for _, value := range nums {
		if value == 0 {
			zeroes++
		}
		if value == 1 {
			ones++
		}
	}

	return zeroes == ones
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
