package dev.romangaranin.leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Helper.test(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
        Helper.test(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        Helper.test(new Solution().search(new int[]{}, 5), -1);
        Helper.test(new Solution().search(new int[]{2}, 2), 0);
        Helper.test(new Solution().search(new int[]{2}, 3), -1);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return -1;
            }

            var low = 0;
            var high = len - 1;

            while (low < high) {
                var mid = (low + high) / 2;
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            var rot = low;

            low = rot;
            high = rot + len - 1;
            while (low < high) {
                var mid = (low + high) / 2;
                if (nums[mid % len] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            if (nums[low % len] == target) {
                return low % len;
            } else {
                return -1;
            }
        }
    }
}
