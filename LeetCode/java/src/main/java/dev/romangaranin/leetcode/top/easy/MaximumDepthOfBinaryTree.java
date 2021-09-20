package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.TreeNode;
import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
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

        test(s.maxDepth(node3), 3);

        test(s.maxDepth(new TreeNode(0)), 1);
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            return maxDepthInner(root, 0);
        }

        private int maxDepthInner(TreeNode node, int depth) {
            if (node == null) {
                return depth;
            }

            var leftDepth = maxDepthInner(node.left, depth + 1);
            var rightDepth = maxDepthInner(node.right, depth + 1);

            return Math.max(leftDepth, rightDepth);
        }
    }

}
