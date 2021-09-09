package dev.romangaranin.leetcode.top.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static dev.romangaranin.leetcode.Helper.test;
import static dev.romangaranin.leetcode.Helper.testArrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public static void main(String[] args) {
        var s = new Solution();

        testArrays(s.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        testArrays(s.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        testArrays(s.twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                var numTwo = Math.abs(target - nums[i]);

                if (map.containsKey(numTwo)) {
                    return new int[]{map.get(numTwo), i};
                } else {
                    map.put(nums[i], i);
                }
            }

            System.out.println("can't find two sum numbers to meet the target");
            return new int[]{-1, -1};
        }
    }
}
