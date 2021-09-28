package dev.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.climbStairs(1), 1);
        test(s.climbStairs(2), 2);
        test(s.climbStairs(3), 3);
    }

    static class Solution {
        public int climbStairs(int n) {
            var mem = new int[n];

            for (int i = 0; i < n - 1; i++) {
                mem[i + 1] += mem[i] + 1;

                if (i + 2 < n - 1) {
                    mem[i + 2] += mem[i] + 1;
                }
            }

            return mem[n - 1] + 1;
        }
    }

}
