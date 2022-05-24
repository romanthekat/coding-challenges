package net.romangaranin.leetcode.top.easy;

import java.util.Map;
import java.util.Stack;

import static net.romangaranin.leetcode.Helper.test;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.isValid("()"), true);
        test(s.isValid("()[]{}"), true);
        test(s.isValid("(]"), false);
        test(s.isValid("([)]"), false);
        test(s.isValid("{[]}"), true);
        test(s.isValid("]"), false);
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }

            var stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stack.push(']');
                } else if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }

    static class SolutionOpeningBracket {
        public boolean isValid(String s) {
            var mapOpenToClose = Map.of('[', ']', '{', '}', '(', ')');
            var stack = new Stack<Character>();

            for (var character : s.toCharArray()) {
                var isOpen = mapOpenToClose.containsKey(character);
                if (isOpen) {
                    stack.push(character);
                    continue;
                }

                var isCloseMismatch = stack.isEmpty() || mapOpenToClose.get(stack.pop()) != character;
                if (isCloseMismatch) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }

    static class SolutionClosingBracket {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            var brackets = Map.of(')', '(', ']', '[', '}', '{');

            for (char c : s.toCharArray()) {
                var isClosingBracket = brackets.containsKey(c);
                if (isClosingBracket) {
                    var openingBracketMismatch = stack.isEmpty() || brackets.get(c) != stack.pop();
                    if (openingBracketMismatch) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }

}
