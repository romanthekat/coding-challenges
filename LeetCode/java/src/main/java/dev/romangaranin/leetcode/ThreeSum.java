package dev.romangaranin.leetcode;

import java.util.List;

import static java.util.List.of;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
class ThreeSum {
    public static void main(String[] args) {
        Helper.test(new Solution().threeSum(new int[]{}), of());
        Helper.test(new Solution().threeSum(new int[]{0}), of());
        Helper.test(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), of(of(-1, -1, 2), of(-1, 0, 1)));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return List.of();
        }
    }
}

