package main

import "fmt"

func main() {
	assert(singleNonDuplicate([]int{1, 1, 2, 3, 3, 4, 4, 8, 8}), 2)
	assert(singleNonDuplicate([]int{3, 3, 7, 7, 10, 11, 11}), 10)
	assert(singleNonDuplicate([]int{1, 2, 2}), 1)
	assert(singleNonDuplicate([]int{1, 1, 2}), 2)
	assert(singleNonDuplicate([]int{1, 1, 2, 2, 3}), 3)
	assert(singleNonDuplicate([]int{1, 2, 2, 3, 3}), 1)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func singleNonDuplicate(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	minIdx := 0
	maxIdx := len(nums) - 1

	for minIdx < maxIdx {
		checkIdx := (minIdx + maxIdx) / 2

		if checkNonDuplicateHappened(nums, checkIdx) {
			maxIdx = checkIdx
		} else {
			minIdx = checkIdx + 1
		}
	}

	return nums[minIdx]
}

func checkNonDuplicateHappened(nums []int, checkIdx int) bool {
	secondCheckIdx := checkIdx

	if checkIdx%2 == 0 {
		secondCheckIdx++
	} else {
		secondCheckIdx--
	}

	return nums[checkIdx] != nums[secondCheckIdx]
}
