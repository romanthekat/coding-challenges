"""
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:
    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
"""
from typing import List

import common


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)

        result = 0
        for num in nums_set:
            if num - 1 not in nums_set:
                current_num = num
                current_longest = 1

                while current_num + 1 in nums_set:
                    current_num += 1
                    current_longest += 1

                result = max(result, current_longest)

        return result


if __name__ == '__main__':
    s = Solution()
    common.assert_equal(s.longestConsecutive([100, 4, 200, 1, 3, 2]), 4)
    common.assert_equal(s.longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]), 9)
    common.assert_equal(s.longestConsecutive([0]), 1)
    common.assert_equal(s.longestConsecutive([]), 0)
