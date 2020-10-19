package dev.romangaranin.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static dev.romangaranin.leetcode.Helper.test;
import static java.util.List.of;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
class ThreeSum {
    public static void main(String[] args) {
        test(new Solution().threeSum(new int[]{}), of());
        test(new Solution().threeSum(new int[]{0}), of());
        test(new Solution().threeSum(new int[]{0, 0, 0}), of(of(0, 0, 0)));
        test(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), of(of(-1, -1, 2), of(-1, 0, 1)));
        test(new Solution().threeSum(new int[]{1, -1, -1, 0}), of(of(-1, 0, 1)));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            var result = new ArrayList<List<Integer>>();

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                var low = i + 1;
                var high = nums.length - 1;
                var sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(List.of(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }

            return result;
        }
    }
}

