"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
"""
from typing import List

from LeetCode.common import assert_equal


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for index_1 in range(len(nums) - 1):
            for index_2 in range(index_1 + 1, len(nums)):
                if (nums[index_1] + nums[index_2]) == target:
                    return [index_1, index_2]

        print("pair not found")
        return [-1, -1]


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.twoSum([2, 7, 11, 15], 9), [0, 1])
    assert_equal(s.twoSum([3, 2, 4], 6), [1, 2])
    assert_equal(s.twoSum([3, 3], 6), [0, 1])
