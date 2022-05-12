"""
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []


Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
"""

from typing import Optional

# Definition for a binary tree node.
import common


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return

        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)

        return root


if __name__ == '__main__':
    s = Solution()

    node4 = TreeNode(4)

    node2 = TreeNode(2)
    node7 = TreeNode(7)
    node4.left = node2
    node4.right = node7

    node1 = TreeNode(1)
    node3 = TreeNode(3)
    node2.left = node1
    node2.right = node3

    node6 = TreeNode(6)
    node9 = TreeNode(9)
    node7.left = node6
    node7.right = node9

    revertedNode4 = s.invertTree(node4)
    common.assert_equal(revertedNode4.val, 4)
    common.assert_equal(revertedNode4.left.val, 7)
    common.assert_equal(revertedNode4.left.left.val, 9)
    common.assert_equal(revertedNode4.left.right.val, 6)

    common.assert_equal(revertedNode4.right.val, 2)
    common.assert_equal(revertedNode4.right.left.val, 3)
    common.assert_equal(revertedNode4.right.right.val, 1)
