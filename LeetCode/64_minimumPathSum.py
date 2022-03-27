"""
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.



Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
"""
from typing import List
from common import assert_equal


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        max_y = len(grid)
        max_x = len(grid[0])

        paths = [[0 for _ in range(max_x)] for _ in range(max_y)]
        paths[0][0] = grid[0][0]

        for i in range(1, max_y):
            paths[i][0] = grid[i][0] + paths[i - 1][0]

        for j in range(1, max_x):
            paths[0][j] = grid[0][j] + paths[0][j - 1]

        for i in range(1, max_y):
            for j in range(1, max_x):
                paths[i][j] = grid[i][j] + min(paths[i][j - 1], paths[i - 1][j])

        return paths[-1][-1]


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]), 7)
    assert_equal(s.minPathSum([[1, 2, 3], [4, 5, 6]]), 12)
