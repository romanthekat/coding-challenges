from common import assert_equal
import sys


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def _is_valid_bst(self, node: TreeNode, min, max) -> bool:
        if not node:
            return True

        if node.val >= max or node.val <= min:
            return False

        return self._is_valid_bst(node.left, min, node.val) and self._is_valid_bst(node.right, node.val, max)

    def isValidBST(self, root: TreeNode) -> bool:
        return self._is_valid_bst(root, -sys.maxsize - 1, sys.maxsize)


if __name__ == '__main__':
    s = Solution()

    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    assert_equal(s.isValidBST(root), True)

    root.right.right = TreeNode(-1)
    assert_equal(s.isValidBST(root), False)

    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(6)

    root.right.left = TreeNode(3)
    root.right.right = TreeNode(7)

    assert_equal(s.isValidBST(root), False)

    root = TreeNode(1)
    root.right = TreeNode(1)
    assert_equal(s.isValidBST(root), False)
