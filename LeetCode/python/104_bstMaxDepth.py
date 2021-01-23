from common import assert_equal


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        max_depth = 0

        queue = [[root, 1]]
        while len(queue) > 0:
            node, depth = queue.pop(0)
            if not node:
                continue

            max_depth = max(depth, max_depth)

            queue.append([node.left, depth + 1])
            queue.append([node.right, depth + 1])

        return max_depth


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

    assert_equal(s.maxDepth(root), 4)
