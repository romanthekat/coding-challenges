"""
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
    1 <= s.length <= 10^4
    s consists of parentheses only '()[]{}'.
"""
import common


class Solution2:
    def isValid(self, s: str) -> bool:
        parentheses = {'[': ']', '{': '}', '(': ')'}
        stack = []

        for c in s:
            if c in parentheses:
                stack.append(c)
                continue

            if not stack or parentheses[stack.pop()] != c:
                return False

        return len(stack) == 0


class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {"(": ")", "[": "]", "{": "}"}
        stack = []

        for char in s:
            if char in brackets:
                stack.append(char)
            else:
                if len(stack) == 0 or brackets.get(stack.pop()) != char:
                    return False

        return len(stack) == 0


if __name__ == '__main__':
    s = Solution2()

    common.assert_equal(s.isValid("()"), True)
    common.assert_equal(s.isValid("()[]{}"), True)
    common.assert_equal(s.isValid("(]"), False)
    common.assert_equal(s.isValid("["), False)
    common.assert_equal(s.isValid("]"), False)
