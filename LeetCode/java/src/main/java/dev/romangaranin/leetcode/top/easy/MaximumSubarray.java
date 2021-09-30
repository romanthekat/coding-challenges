package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        var s = new Solution();
        test(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
        test(s.maxSubArray(new int[]{1}), 1);
        test(s.maxSubArray(new int[]{5, 4, -1, 7, 8}), 23);
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            var maxSoFar = nums[0];
            var maxIfTake = nums[0];

            for (int i = 1; i < nums.length; i++) {
                maxIfTake = Math.max(nums[i], maxIfTake + nums[i]);
                if (maxIfTake > maxSoFar) {
                    maxSoFar = maxIfTake;
                }
            }

            return maxSoFar;
        }
    }
}
