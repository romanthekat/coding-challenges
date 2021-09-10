package dev.romangaranin.leetcode.top.easy;

import java.util.HashMap;
import java.util.HashSet;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 */
public class FirstUniqCharInString {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.firstUniqChar("leetcode"), 0);
        test(s.firstUniqChar("loveleetcode"), 2);
        test(s.firstUniqChar("aabb"), -1);
    }

    static class Solution {
        public int firstUniqChar(String s) {
            var length = s.length();

            var map = new HashMap<Character, Integer>();
            for (var i = 0; i < length; i++) {
                var c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (var i = 0; i < length; i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}
