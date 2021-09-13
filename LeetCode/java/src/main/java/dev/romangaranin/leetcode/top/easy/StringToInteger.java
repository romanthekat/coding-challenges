package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.

Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class StringToInteger {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.myAtoi("42"), 42);
        test(s.myAtoi("-42"), -42);
        test(s.myAtoi("    -42"), -42);
        test(s.myAtoi("    -91283472332"), -2147483648);
        test(s.myAtoi("4193 with words"), 4193);
        test(s.myAtoi("words and 987"), 0);
        test(s.myAtoi(""), 0);
        test(s.myAtoi("+1"), 1);
        test(s.myAtoi("-1"), -1);
        test(s.myAtoi("2147483646"), 2147483646);
    }

    static class Solution {
        public int myAtoi(String s) {
            var result = 0;
            var isPositive = true;
            var idx = 0;

            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }

            switch (s.charAt(0)) {
                case '+':
                    idx++;
                    break;
                case '-':
                    isPositive = false;
                    idx++;
                    break;
            }

            while (idx < s.length()) {
                var character = s.charAt(idx);
                if (character < '0' || character > '9') {
                    break;
                }

                var digit = character - '0';

                if (Integer.MAX_VALUE / 10 < result
                        || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = result * 10 + digit;
                idx++;
            }

            return isPositive ? result : result * -1;
        }
    }
}

