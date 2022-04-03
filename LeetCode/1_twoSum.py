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
import collections
from typing import List

from common import assert_equal


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}

        for i, num in enumerate(nums):
            another_num = target - num
            if another_num in d:
                return [d[another_num], i]
            else:
                d[num] = i

        print("result not found")
        return [-1, -1]


class Solution2:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = collections.defaultdict()

        for idx, num in enumerate(nums):
            if target - num in d:
                return [d[target - num], idx]
            d[num] = idx

        print("pair not found")
        return [-1, -1]


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.twoSum([2, 7, 11, 15], 9), [0, 1])
    assert_equal(s.twoSum([3, 2, 4], 6), [1, 2])
    assert_equal(s.twoSum([3, 3], 6), [0, 1])
