package main

import (
	"github.com/EvilKhaosKat/coding-challenges/LeetCode/golang/common"
	"math"
)

/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Constraints:
- 1 <= nums.length <= 2 * 10^4
- -2^31 <= nums[i] <= 2^31 - 1

*/
func main() {
	common.AssertEqual(maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6)
	common.AssertEqual(maxSubArray([]int{-1}), -1)
}

func maxSubArray(nums []int) int {
	maxSum := math.MinInt32
	currSum := 0

	for _, num := range nums {
		if num > currSum+num {
			currSum = num
		} else {
			currSum += num
		}

		if currSum > maxSum {
			maxSum = currSum
		}
	}

	return maxSum
}
