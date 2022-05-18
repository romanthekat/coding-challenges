"""
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]



Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
"""
from typing import List

import common

class SolutionGroup4:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for row in range(n//2):
            for col in range(row, n-row-1):
                matrix[row][col], matrix[col][n-1-row] = matrix[col][n-1-row], matrix[row][col]
                matrix[row][col], matrix[n-1-row][n-1-col] = matrix[n-1-row][n-1-col], matrix[row][col]
                matrix[row][col], matrix[n-1-col][row] = matrix[n-1-col][row], matrix[row][col]


class SolutionAlgebra:
    def _transpose(self, matrix: List[List[int]]):
        n = len(matrix)

        for row in range(n):
            for col in range(row + 1, n):
                matrix[row][col], matrix[col][row] = matrix[col][row], matrix[row][col]

    def _reflect(self, matrix: List[List[int]]):
        n = len(matrix)
        for row in range(n):
            for col in range(n // 2):
                matrix[row][col], matrix[row][-col - 1] = matrix[row][-col - 1], matrix[row][col]

    def rotate(self, matrix: List[List[int]]) -> None:
        self._transpose(matrix)
        self._reflect(matrix)


if __name__ == '__main__':
    s = SolutionGroup4()
    matrix_1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    s.rotate(matrix_1)
    common.assert_equal(matrix_1, [[7, 4, 1], [8, 5, 2], [9, 6, 3]])

    matrix_2 = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
    s.rotate(matrix_2)
    common.assert_equal(matrix_2, [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]])
