package dev.romangaranin.leetcode.exp;

//Fibonacci summ of two prev
//0 0
//1 1
//2 1
//3 2
//4 3
//5 5
//recursion, memoization
//iterative, dynamic programming
//input: [0, 1000]
public class Task20211113 {
    public static void main(String[] args) {
        var s = new Solution();

        System.out.println(s.getFibonnaci(0) + " vs 0");
        System.out.println(s.getFibonnaci(1) + " vs 1");
        System.out.println(s.getFibonnaci(2) + " vs 1");
        System.out.println(s.getFibonnaci(3) + " vs 2");
        System.out.println(s.getFibonnaci(4) + " vs 3");
        System.out.println(s.getFibonnaci(5) + " vs 5");
        System.out.println(s.getFibonnaci(6) + " vs 8");
        System.out.println(s.getFibonnaci(7) + " vs 13");

        System.out.println();
        System.out.println(s.getFibonnaciRec(0) + " vs 0");
        System.out.println(s.getFibonnaciRec(1) + " vs 1");
        System.out.println(s.getFibonnaciRec(2) + " vs 1");
        System.out.println(s.getFibonnaciRec(3) + " vs 2");
        System.out.println(s.getFibonnaciRec(4) + " vs 3");
        System.out.println(s.getFibonnaciRec(5) + " vs 5");
        System.out.println(s.getFibonnaciRec(6) + " vs 8");
        System.out.println(s.getFibonnaciRec(7) + " vs 13");
    }

    /**
     * def calculateFibonacci(n):
     * memo = [-1 for _ in range(n + 1)]
     * <p>
     * return calculateFibonacci_rec(memo, n)
     * <p>
     * <p>
     * def calculateFibonacci_rec(memo, n):
     * if n < 2:
     * return n
     * <p>
     * if memo[n] == -1:
     * memo[n] = calculateFibonacci_rec(memo, n - 1) + calculateFibonacci_rec(memo, n - 2)
     * <p>
     * return memo[n]
     */
    static class Solution {
        public int getFibonnaci(int index) {
            if (index == 0) {
                return 0;
            } else if (index == 1) {
                return 1;
            }

            var prePrev = 0;
            var prev = 1;

            var res = 0;

            for (int i = 2; i <= index; i++) {
                res = prePrev + prev;

                prePrev = prev;
                prev = res;
            }

            return res;
        }

        public int getFibonnaciRec(int index) {
            var memo = new int[index + 1];
            for (int i = 0; i <= index; i++) {
                memo[i] = -1;
            }

            return getFibonnaciRecWithMemo(index, memo);
        }

        private int getFibonnaciRecWithMemo(int index,
                                            int[] memo) {
            if (index < 2) {
                return index;
            }

            if (memo[index] == -1) {
                memo[index] = getFibonnaciRecWithMemo(index - 2, memo) + getFibonnaciRecWithMemo(index - 1, memo);
            }

            return memo[index];
        }

    }
}
