package dev.romangaranin.leetcode;

import dev.romangaranin.leetcode.Helper;

import java.util.*;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        test(new Solution().isValid("()"), true);
        test(new Solution().isValid("()[]{}"), true);
        test(new Solution().isValid("(]"), false);
        test(new Solution().isValid("{[]}"), true);
        test(new Solution().isValid("([)]"), false);
        test(new Solution().isValid("["), false);
        test(new Solution().isValid(""), true);
    }

    static class Solution {
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

