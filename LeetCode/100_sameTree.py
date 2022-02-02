from common import assert_equal


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        first_stack = [p]
        second_stack = [q]
        while len(first_stack) != 0 and len(second_stack) != 0:
            first = first_stack.pop()
            second = second_stack.pop()

            if not first and not second:
                continue

            if not first or not second:
                return False

            if first and second and first.val != second.val:
                return False

            first_stack.append(first.left)
            first_stack.append(first.right)
            second_stack.append(second.left)
            second_stack.append(second.right)

        return len(first_stack) == len(second_stack)


if __name__ == '__main__':
    s = Solution()

    root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)

    root5 = TreeNode(5)
    root5.left = TreeNode(4)
    root5.right = TreeNode(6)

    assert_equal(s.isSameTree(root2, root5), False)
    assert_equal(s.isSameTree(root2, root2), True)

    root1 = TreeNode(1)
    root1.left = TreeNode(0)

    root1Wrong = TreeNode(1)
    root1Wrong.right = TreeNode(0)

    assert_equal(s.isSameTree(root1, root1Wrong), False)
