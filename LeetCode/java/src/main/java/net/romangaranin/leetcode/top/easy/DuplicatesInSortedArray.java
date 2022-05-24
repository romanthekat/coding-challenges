package net.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Constraints:
 * <p>
 * - 0 <= nums.length <= 3 * 104
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order.
 */
public class DuplicatesInSortedArray {
    public static void main(String[] args) {
        var s = new Solution();
        var input1 = new int[]{1, 1, 2};
        test(s.removeDuplicates(input1), 2);
        test(input1[0], 1);
        test(input1[1], 2);
        System.out.println();

        var input2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        test(s.removeDuplicates(input2), 5);
        test(input2[0], 0);
        test(input2[1], 1);
        test(input2[2], 2);
        test(input2[3], 3);
        test(input2[4], 4);
        System.out.println();

        test(s.removeDuplicates(new int[]{}), 0);
        test(s.removeDuplicates(new int[]{1, 1}), 1);
        test(s.removeDuplicates(new int[]{1, 2}), 2);
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return nums.length;
            }

            var writeIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[writeIndex]) {
                    writeIndex++;
                    nums[writeIndex] = nums[i];
                }
            }

            return writeIndex + 1;
        }
    }
}
