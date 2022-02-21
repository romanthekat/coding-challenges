"""
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
    n == height.length
    2 <= n <= 10^5
    0 <= height[i] <= 10^4
"""
from typing import List

from LeetCode.common import assert_equal


class BruteforceSolution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0

        for i in range(len(height) - 1):
            for j in range(1, len(height)):
                first = height[i]
                second = height[j]

                max_area = max(max_area, (j - i) * min(first, second))

        return max_area


if __name__ == '__main__':
    s = BruteforceSolution()

    assert_equal(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]), 49)
    assert_equal(s.maxArea([1, 1]), 1)
