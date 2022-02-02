"""
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
"""
from typing import List

from common import assert_equal


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [1] * len(nums)

        product = 1
        for index, num in enumerate(nums):
            result[index] *= product
            product *= num

        product = 1
        index = len(nums) - 1
        for num in reversed(nums):
            result[index] *= product
            product *= num

            index -= 1

        return result


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.productExceptSelf([1, 2, 3, 4]), [24, 12, 8, 6])
