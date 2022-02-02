"""
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true

Example 2:

Input: [1,2,3,4]
Output: false

Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
"""
from typing import List

from common import assert_equal


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        """
        Well, naive iteration, sort and check for duplicates, or simply create set and compare sizes.
        Create set on the fly and check for duplicates for better time.
        :param nums:
        :return:
        """
        nums_set = set(nums)
        return len(nums) != len(nums_set)


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.containsDuplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]), True)
    assert_equal(s.containsDuplicate([1, 2, 3, 4]), False)
