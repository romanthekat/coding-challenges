package main

import (
	"fmt"
	"math"
)

func main() {
	assert(maxSubarraySumCircular([]int{1, -2, 3, -2}), 3)
	assert(maxSubarraySumCircular([]int{5, -3, 5}), 10)
	assert(maxSubarraySumCircular([]int{3, -1, 2, -1}), 4)
	assert(maxSubarraySumCircular([]int{3, -2, 2, -3}), 3)
	assert(maxSubarraySumCircular([]int{-2, -3, -1}), -1)
}

func assert(got, want interface{}) {
	fmt.Printf("%t|got: %t, want: %t\n", got == want, got, want)
}

func maxSubarraySumCircular(array []int) int {
	maxKadane, negativeOnly := kadane(array)
	if negativeOnly {
		return maxKadane
	}

	maxSplit := 0
	for i, value := range array {
		maxSplit += value
		array[i] *= -1
	}

	revertedKadane, _ := kadane(array)
	maxSplit += revertedKadane

	return max(maxKadane, maxSplit)
}

func kadane(array []int) (int, bool) {
	negativeOnly := true

	maxSum := math.MinInt32
	curSum := math.MinInt32

	for _, value := range array {
		curSum = max(curSum+value, value)
		maxSum = max(curSum, maxSum)

		if value > 0 {
			negativeOnly = false
		}
	}

	return maxSum, negativeOnly
}

func max(f, s int) int {
	if f > s {
		return f
	} else {
		return s
	}
}
