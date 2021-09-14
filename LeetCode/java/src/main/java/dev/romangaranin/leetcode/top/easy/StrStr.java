package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Implement [strStr()](https://www.cplusplus.com/reference/cstring/strstr/).
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Example 3:
 * <p>
 * Input: haystack = "", needle = ""
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack and needle consist of only lower-case English characters.
 */
public class StrStr {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.strStr("hello", "ll"), 2);
        test(s.strStr("hello", "llo"), 2);
        test(s.strStr("hello", "he"), 0);
        test(s.strStr("aaaaa", "bba"), -1);
        test(s.strStr("", ""), 0);
        test(s.strStr("a", "a"), 0);
        test(s.strStr("mississippi", "issip"), 4);
    }

    //KMP algo would be much better
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    var isContain = isContainFromSecondLetter(haystack, needle, i);
                    if (isContain) {
                        return i;
                    }
                }
            }

            return -1;
        }

        //ugly, but no reason to compare first letter again; alternative to continue outer loop rather than using label
        //and it's faster than inlining for some reasons (maybe alternative did excess memory allocations)
        private boolean isContainFromSecondLetter(String haystack, String needle, int startIndex) {
            for (int j = 1; j < needle.length(); j++) {
                if (haystack.charAt(startIndex + j) != needle.charAt(j)) {
                    return false;
                }
            }

            return true;
        }
    }

    //works faster
    static class SolutionWhileLoop {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }

            //a tad faster with arrays rather than string.charAt?
            var haystackArray = haystack.toCharArray();
            var needleArray = needle.toCharArray();

            var i = 0;
            var j = 0;

            while (i < haystack.length()) {
                if (haystackArray[i] == needleArray[j]) {
                    i++;
                    j++;
                } else {
                    i = i - j + 1;
                    j = 0;
                    continue;
                }

                if (j == needleArray.length) {
                    return i - needleArray.length;
                }
            }

            return -1;
        }
    }
}
