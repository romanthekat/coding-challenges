"""
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?



Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -2^31 <= matrix[i][j] <= 2^31 - 1
"""
from typing import List

from common import assert_equal


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        clear_zero_col: bool = False
        for row in range(0, len(matrix)):
            if matrix[row][0] == 0:
                clear_zero_col = True
            for col in range(1, len(matrix[0])):
                if matrix[row][col] == 0:
                    matrix[row][0] = 0
                    matrix[0][col] = 0

        for row in reversed(range(0, len(matrix))):
            for col in reversed(range(1, len(matrix[0]))):
                if matrix[row][0] == 0 or matrix[0][col] == 0:
                    matrix[row][col] = 0
            if clear_zero_col:
                matrix[row][0] = 0


if __name__ == '__main__':
    s = Solution()

    m = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    s.setZeroes(m)
    assert_equal(m, [[1, 0, 1], [0, 0, 0], [1, 0, 1]])

    m = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]
    s.setZeroes(m)
    assert_equal(m, [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]])

    m = [[1, 2, 3, 4],
         [5, 0, 7, 8],
         [0, 10, 11, 12],
         [13, 14, 15, 0]]
    s.setZeroes(m)
    assert_equal(m, [[0, 0, 3, 0],
                     [0, 0, 0, 0],
                     [0, 0, 0, 0],
                     [0, 0, 0, 0]])
