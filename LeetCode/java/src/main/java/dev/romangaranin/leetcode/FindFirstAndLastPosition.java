package dev.romangaranin.leetcode;

import static dev.romangaranin.leetcode.Helper.test;
import static dev.romangaranin.leetcode.Helper.testArrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * <p>
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * nums is a non-decreasing array.
 * <p>
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        testArrays(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4});
        testArrays(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1});
        testArrays(new Solution().searchRange(new int[]{}, 42), new int[]{-1, -1});
        testArrays(new Solution().searchRange(new int[]{1}, 42), new int[]{-1, -1});
        testArrays(new Solution().searchRange(new int[]{42}, 42), new int[]{0, 0});
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            var low = 0;
            var high = nums.length - 1;

            while (low < high) {
                var mid = (low + high) / 2;

                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            if (nums.length == 0 || nums[low] != target) {
                return new int[]{-1, -1};
            }

            var first = low;
            var last = low; //TODO second binary search for faster last entry search
            while (last < nums.length - 1 && nums[last + 1] == target) {
                last++;
            }

            return new int[]{first, last};
        }
    }
}
