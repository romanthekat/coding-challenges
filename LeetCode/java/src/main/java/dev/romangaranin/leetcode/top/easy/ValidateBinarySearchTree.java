package dev.romangaranin.leetcode.top.easy;

import dev.romangaranin.leetcode.Helper.TreeNode;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        var s = new Solution();

        var node3 = new TreeNode(3);
        var node9 = new TreeNode(9);
        var node20 = new TreeNode(20);
        var node15 = new TreeNode(15);
        var node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        test(s.isValidBST(node3), false);

        var node10 = new TreeNode(10, new TreeNode(11), new TreeNode(9));
        test(s.isValidBST(node10), false);

        var node128 = new TreeNode(128,
                new TreeNode(64, new TreeNode(32), new TreeNode(72)),
                new TreeNode(256, null, new TreeNode(512)));
        test(s.isValidBST(node128), true);

        var case4 = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        test(s.isValidBST(case4), false);

        test(s.isValidBST(new TreeNode(2147483647)), true);
    }

    static class Solution {
        public boolean isValidBST(TreeNode node) {
            return isValidBST(node, null, null);
        }

        protected boolean isValidBST(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            return (min == null || min < node.val)
                    && (max == null || node.val < max)
                    && isValidBST(node.left, min, node.val)
                    && isValidBST(node.right, node.val, max);
        }
    }

}
