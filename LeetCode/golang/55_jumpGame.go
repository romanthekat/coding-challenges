package main

import "github.com/EvilKhaosKat/coding-challenges/LeetCode/golang/common"

func main() {
	common.Assert(canJump([]int{2, 3, 1, 1, 4}), true)
	common.Assert(canJump([]int{3, 2, 1, 0, 4}), false)
}

/**
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
    1 <= nums.length <= 3 * 10^4
    0 <= nums[i] <= 10^5
*/
//alternatively: use backpropagation (start from last index, check whether you can reach start)
func canJump(nums []int) bool {
	maxIndex := 0

	for index, jump := range nums {
		if index > maxIndex {
			return false
		}

		maxIndex = Max(maxIndex, index+jump)
	}

	return true
}

func Max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
