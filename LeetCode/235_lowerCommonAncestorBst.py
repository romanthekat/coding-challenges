from common import assert_equal


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        node = root
        while node:
            if node.val > p.val and node.val > q.val:
                node = node.left
            elif node.val < p.val and node.val < q.val:
                node = node.right
            else:
                return node

        raise Exception("iteration finished before result found - check nodes actually included in tree")


if __name__ == '__main__':
    s = Solution()

    root = TreeNode(6)
    node4 = TreeNode(4)
    node8 = TreeNode(8)
    root.left = node4
    root.right = node8

    node7 = TreeNode(7)
    node9 = TreeNode(9)
    node8.left = node7
    node8.right = node9

    node10 = TreeNode(10)
    node9.right = node10

    assert_equal(s.lowestCommonAncestor(root, node10, node7).val, node8.val)
