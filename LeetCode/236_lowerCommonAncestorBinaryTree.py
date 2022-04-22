"""
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
"""

from common import assert_equal


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class SolutionRecurrentCleaner:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def lca(node: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
            if not node:
                return None

            if node == p or node == q:
                return node

            left = lca(node.left, p, q)
            right = lca(node.right, p, q)

            if left and right:
                return node

            if left:
                return left
            else:
                return right

        return lca(root, p, q)


class SolutionRecurrent:
    def __init__(self):
        self.ans = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def recursive(node) -> bool:
            if not node or self.ans:
                return False

            left = recursive(node.left)
            right = recursive(node.right)
            mid = node == p or node == q

            if left + mid + right >= 2:
                self.ans = node

            return left or mid or right

        recursive(root)
        return self.ans


if __name__ == '__main__':
    s = SolutionRecurrentCleaner()

    root = TreeNode(3)
    node5 = TreeNode(5)
    node1 = TreeNode(1)
    root.left = node5
    root.right = node1

    node6 = TreeNode(6)
    node2 = TreeNode(2)
    node5.left = node6
    node5.right = node2

    node0 = TreeNode(0)
    node8 = TreeNode(8)
    node1.left = node0
    node1.right = node8

    assert_equal(s.lowestCommonAncestor(root, node5, node1).val, root.val)
