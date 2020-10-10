package dev.romangaranin.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
 * -105 <= nums[i] <= 105
 */
class ThreeSum {
    public static void main(String[] args) {
        Helper.test(new Solution().threeSum(new int[]{}), of());
        Helper.test(new Solution().threeSum(new int[]{0}), of());
        Helper.test(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), of(of(-1, -1, 2), of(-1, 0, 1)));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            var result = new HashMap<List<Integer>, Map<Integer, Long>>();

            if (nums.length < 3) {
                return List.of();
            }

            for (int i = 0; i < nums.length - 2; i++) {
                var first = nums[i];
                for (int j = i + 1; j < nums.length - 1; j++) {
                    var second = nums[j];
                    for (int k = j + 1; k < nums.length; k++) {
                        var third = nums[k];

                        if ((first + second + third) == 0) {
                            var triple = List.of(first, second, third);
                            var tripleValuesMap = triple.stream()
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                            if (result.values().stream().noneMatch(it -> it.equals(tripleValuesMap))) {
                                result.put(triple, tripleValuesMap);
                            }
                        }
                    }
                }
            }

            return result.keySet().stream()
                    .map(ArrayList::new)
                    .collect(Collectors.toList());
        }
    }
}

