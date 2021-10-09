package dev.romangaranin.leetcode.top.medium;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        var s = new Solution();
        test(s.longestPalindrome("bb"), "bb");
        test(s.longestPalindrome("babad"), "aba");
        test(s.longestPalindrome("cbbd"), "bb");
        test(s.longestPalindrome("a"), "a");
        test(s.longestPalindrome("ac"), "c");
        test(s.longestPalindrome("eabcb"), "bcb");
    }

    static class Solution {
        public String longestPalindrome(String s) {
            var from = 0;
            var to = 0;
            for (int i = 0; i < s.length(); i++) {
                var lenOdd = expandAround(s, i, i);
                var lenEven = expandAround(s, i, i + 1);
                var maxLen = Math.max(lenOdd, lenEven);

                if (maxLen > to - from) {
                    from = i - (maxLen - 1) / 2;
                    to = i + maxLen / 2;
                }
            }

            return s.substring(from, to + 1);
        }

        protected int expandAround(String string, int from, int to) {
            while (from >= 0 && to < string.length() && string.charAt(from) == string.charAt(to)) {
                from--;
                to++;
            }

            return to - from - 1;
        }
    }

}
