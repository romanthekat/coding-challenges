package net.romangaranin.leetcode.top.easy;

import net.romangaranin.leetcode.Helper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        var s = new Solution();

        Helper.test(s.levelOrder(null), new ArrayList<>());
        Helper.test(s.levelOrder(new Helper.TreeNode(1)), List.of(List.of(1)));

        var case2 = new Helper.TreeNode(128,
                new Helper.TreeNode(64, new Helper.TreeNode(32), new Helper.TreeNode(72)),
                new Helper.TreeNode(256, null, new Helper.TreeNode(512)));
        Helper.test(s.levelOrder(case2), List.of(
                List.of(128),
                List.of(64, 256),
                List.of(32, 72, 512)
        ));
    }

    //TODO current queue size == whole level, so whole X nodes for a level can be polled at once, offering new items
    static class Solution {
        public List<List<Integer>> levelOrder(Helper.TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            var nodes = new ArrayDeque<Helper.TreeNode>();
            nodes.offer(root);

            var levels = new ArrayDeque<Integer>();
            levels.offer(0);

            while (!nodes.isEmpty()) {
                var node = nodes.poll();
                var level = levels.poll();

                if (result.size() < level + 1) {
                    result.add(new ArrayList<>());
                }
                var levelNodes = result.get(level);

                levelNodes.add(node.val);

                if (node.left != null) {
                    nodes.offer(node.left);
                    levels.offer(level + 1);
                }

                if (node.right != null) {
                    nodes.offer(node.right);
                    levels.offer(level + 1);
                }
            }

            return result;
        }
    }

}
