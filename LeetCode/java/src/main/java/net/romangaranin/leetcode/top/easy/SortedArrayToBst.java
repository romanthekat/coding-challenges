package net.romangaranin.leetcode.top.easy;

import dev.romangaranin.leetcode.Helper.TreeNode;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 */
public class SortedArrayToBst {
    public static void main(String[] args) {
        var s = new Solution();

        var result1 = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        test(result1.val, 0);
        test(result1.left.val, -10);
        test(result1.left.right.val, -3);
        test(result1.right.val, 5);
        test(result1.right.right.val, 9);
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        protected TreeNode sortedArrayToBST(int[] nums, int from, int to) {
            if (from > to) {
                return null;
            }

            var mid = from + (to - from) / 2;

            var root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, from, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, to);

            return root;
        }
    }

}
