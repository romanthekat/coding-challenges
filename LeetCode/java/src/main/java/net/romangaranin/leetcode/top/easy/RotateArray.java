package net.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.testArrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    /**
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     *
     * @param args
     */
    public static void main(String[] args) {
        var s = new Solution();

        var inputReverse = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.reverse(inputReverse, 0, inputReverse.length - 1);
        testArrays(inputReverse, new int[]{7, 6, 5, 4, 3, 2, 1});

        //1, 2, 3, 4, 5, 6, 7 k=1
        //7, 1, 2, 3, 4, 5, 6
        var input0 = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(input0, 1);
        testArrays(input0, new int[]{7, 1, 2, 3, 4, 5, 6});

        //1, 2, 3,|4, 5, 6, 7 k=3
        //7, 6, 5,|4, 3, 2, 1
        //5, 6, 7,|4, 3, 2, 1
        //5, 6, 7,|1, 2, 3, 4
        //5, 6, 7,|1, 2, 3, 4
        var input1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(input1, 3);
        testArrays(input1, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        protected void reverse(int[] nums, int left, int right) {
            while (left < right) {
                var temp = nums[left];

                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
    }
}
