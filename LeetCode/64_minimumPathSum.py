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
import sys
from typing import List
from common import assert_equal


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        paths = [[0 for _ in range(len(grid[0]))] for _ in range(len(grid))]

        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if i == 0 and j == 0:
                    paths[0][0] = grid[0][0]
                    continue

                up = self.get_path(paths, i, j - 1)
                left = self.get_path(paths, i - 1, j)
                paths[i][j] = grid[i][j] + min(left, up)

        return paths[-1][-1]

    def get_path(self, paths, x, y) -> int:
        if x < 0 or x >= len(paths) or y < 0 or y >= len(paths[0]):
            return sys.maxsize

        return paths[x][y]


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]), 7)
    assert_equal(s.minPathSum([[1, 2, 3], [4, 5, 6]]), 12)
