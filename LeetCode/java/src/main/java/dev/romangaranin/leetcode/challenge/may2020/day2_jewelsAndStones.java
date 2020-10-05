package dev.romangaranin.leetcode.challenge.may2020;

import java.util.HashSet;
import java.util.Set;

/**
 * == day 2: Jewels and Stones
 *
 * You're given strings `J` representing the types of stones that are jewels, and `S` representing the stones you have.
 * Each character in `S` is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in `J` are guaranteed distinct, and all characters in `J` and `S` are letters.
 * Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.
 *
 * Example 1:
 *
 * [source]
 * ----
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * ----
 *
 * Example 2:
 *
 * [source]
 * ----
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * ----
 *
 * Note:
 *
 *     S and J will consist of letters and have length at most 50.
 *     The characters in J are distinct.
 */
public class day2_jewelsAndStones {
    public static void main(String[] args) {
        check(3, new Solution().numJewelsInStones("aA", "aAAbbbb"));
        check(0, new Solution().numJewelsInStones("z", "ZZ"));
    }

    protected static void check(int want, int actual) {
        System.out.printf("%s | want: %s, actual: %s\n", want == actual, want, actual);
    }

    static class Solution {
        public int numJewelsInStones(String j, String s) {
            //alternatively: array of chars (26x2 size): faster, but lacks extensibility
            Set<Character> jewels = new HashSet<>();
            for (char jewel : j.toCharArray()) {
                jewels.add(jewel);
            }

            int result = 0;

            for (char stone : s.toCharArray()) {
                if (jewels.contains(stone)) {
                    result++;
                }
            }

            return result;
        }
    }
}
