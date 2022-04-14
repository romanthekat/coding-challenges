"""
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
"""

# Definition for a binary tree node.
from typing import List

from common import assert_equal


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self) -> str:
        return self.val.__str__()


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        result = []

        nodes = [root]
        while nodes:
            current_level = []
            current_level_len = len(nodes)
            result.append(current_level)

            for _ in range(current_level_len):
                node = nodes.pop(0)
                current_level.append(node.val)

                if node.left:
                    nodes.append(node.left)
                if node.right:
                    nodes.append(node.right)

        return result


class Solution2:
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
