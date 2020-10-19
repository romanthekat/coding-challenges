package dev.romangaranin.leetcode;

import static dev.romangaranin.leetcode.Helper.test2dArrays;
import static dev.romangaranin.leetcode.Helper.testArrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Example 3:
 * <p>
 * Input: matrix = [[1]]
 * Output: [[1]]
 * <p>
 * Example 4:
 * <p>
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * matrix.length == n
 * <p>
 * matrix[i].length == n
 * <p>
 * 1 <= n <= 20
 * <p>
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {
    public static void main(String[] args) {
        var matrixOf9 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrixOf9);
        test2dArrays(matrixOf9, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});

        var matrixOf1 = new int[][]{{1}};
        new Solution().rotate(matrixOf1);
        test2dArrays(matrixOf1, new int[][]{{1}});
    }

    static class Solution {
        public void rotate(int[][] matrix) {

        }
    }
}
