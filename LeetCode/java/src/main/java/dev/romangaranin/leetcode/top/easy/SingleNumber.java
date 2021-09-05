package dev.romangaranin.leetcode.top.easy;

import java.util.Arrays;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {
    public static void main(String[] args) {
        var s = new Solution();
        test(s.singleNumber(new int[]{2, 2, 1}), 1);
        test(s.singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
        test(s.singleNumber(new int[]{1}), 1);
        test(s.singleNumber(new int[]{1, 1, 2, 2, 3}), 3);
        test(s.singleNumber(new int[]{1, 1, 2, 3, 3}), 2);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            var result = 0;

            for (int num : nums) {
                result ^= num;
            }

            return result;
        }
    }

    static class SolutionSort {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i = i + 2) {
                if (nums[i - 1] != nums[i]) {
                    return nums[i - 1];
                }
            }

            return nums[nums.length - 1];
        }
    }
}
