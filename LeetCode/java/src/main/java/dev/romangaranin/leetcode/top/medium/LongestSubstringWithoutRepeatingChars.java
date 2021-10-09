package dev.romangaranin.leetcode.top.medium;

import java.util.HashMap;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.lengthOfLongestSubstring("abcabcbb"), 3);
        test(s.lengthOfLongestSubstring("bbbbb"), 1);
        test(s.lengthOfLongestSubstring("pwwkew"), 3);
        test(s.lengthOfLongestSubstring(""), 0);
        test(s.lengthOfLongestSubstring("aab"), 2);
        test(s.lengthOfLongestSubstring("dvdf"), 3);
        test(s.lengthOfLongestSubstring("bbtablud"), 6);
        test(s.lengthOfLongestSubstring("abba"), 2);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            var longest = 0;

            var startIdx = 0;
            var seen = new HashMap<Character, Integer>();

            for (int idx = 0; idx < s.length(); idx++) {
                var c = s.charAt(idx);

                if (seen.containsKey(c)) {
                    startIdx = Math.max(startIdx, seen.get(c) + 1);
                }

                seen.put(c, idx);
                longest = Math.max(longest, idx - startIdx + 1);
            }

            return longest;
        }
    }

}
