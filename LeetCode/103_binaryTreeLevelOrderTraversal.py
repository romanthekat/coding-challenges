# Definition for a binary tree node.
from typing import List

from common import assert_equal


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []

        queue = [[root, 0]]
        while len(queue) > 0:
            node, level = queue.pop(0)
            if not node:
                continue

            self._add(result, level, node.val)

            queue.append([node.left, level + 1])
            queue.append([node.right, level + 1])

        return result

    def _add(self, result: List[List[int]], level, value):
        if len(result) <= level:
            result.append([])

        result[level].append(value)


if __name__ == '__main__':
    s = Solution()

    root = TreeNode(6)
    node4 = TreeNode(4)
    node8 = TreeNode(8)
    root.left = node4
    root.right = node8

    node4.left = TreeNode(2)

    node8.left = TreeNode(7)
    node8.right = TreeNode(9)

    node8.right.right = TreeNode(10)

    assert_equal(s.levelOrder(root), [[6], [4, 8], [2, 7, 9], [10]])
