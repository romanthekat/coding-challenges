"""
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.
"""
from typing import List

from common import assert_equal


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = {}
        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1

        bucket = [None] * (len(nums) + 1)

        for num, freq in freq_map.items():
            if not bucket[freq]:
                bucket[freq] = []

            bucket[freq].append(num)

        result = []

        for i in range(len(bucket) - 1, 0, -1):
            values = bucket[i]
            if not values:
                continue

            result.extend(values)

            if len(result) >= k:
                break

        return result


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.topKFrequent([1, 1, 1, 2, 2, 3], 2), [1, 2])
    assert_equal(s.topKFrequent([1], 1), [1])
    assert_equal(s.topKFrequent([-1, -1], 1), [-1])
