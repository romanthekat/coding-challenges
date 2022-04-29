"""
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
"""
from typing import List

import common


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0

        max_row = len(grid)
        max_col = len(grid[0])
        visited = [[False for _ in range(max_col)] for _ in range(max_row)]

        def expand(row, col, result):
            result += 1

            to_visit = [(row, col)]
            while to_visit:
                check_row, check_col = to_visit.pop()
                if grid[check_row][check_col] == "1" and not visited[check_row][check_col]:
                    visited[check_row][check_col] = True
                    for delta_row, delta_col in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                        if 0 <= check_row + delta_row < max_row and 0 <= check_col + delta_col < max_col:
                            to_visit.append((check_row + delta_row, check_col + delta_col))

            return result

        for row in range(max_row):
            for col in range(max_col):
                if grid[row][col] == "1" and not visited[row][col]:
                    result = expand(row, col, result)

        return result


if __name__ == '__main__':
    s = Solution()
    common.assert_equal(s.numIslands([["1", "1", "1", "1", "0"],
                                      ["1", "1", "0", "1", "0"],
                                      ["1", "1", "0", "0", "0"],
                                      ["0", "0", "0", "0", "0"]]),
                        1)
    common.assert_equal(s.numIslands([["1", "1", "0", "0", "0"],
                                      ["1", "1", "0", "0", "0"],
                                      ["0", "0", "1", "0", "0"],
                                      ["0", "0", "0", "1", "1"]
                                      ]),
                        3)

    common.assert_equal(s.numIslands([["1", "0", "1", "1", "0", "1", "1"]]),
                        3)
