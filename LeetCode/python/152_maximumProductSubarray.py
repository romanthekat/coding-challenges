"""
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
"""
from typing import List

from common import assert_equal


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        result = min_product = max_product = nums[0]
        for index in range(1, len(nums)):
            num = nums[index]

            max_product = max(num, max_product * num, min_product * num)
            min_product = min(num, min_product * num, max_product * num)

            result = max(result, max_product)

        return result


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.maxProduct([2, 3, -2, 4]), 6)
    assert_equal(s.maxProduct([-2, 0, -1]), 0)
    assert_equal(s.maxProduct([-2]), -2)
    assert_equal(s.maxProduct([-2, 3, -4]), 24)
    assert_equal(s.maxProduct([3, -1, 4]), 4)
