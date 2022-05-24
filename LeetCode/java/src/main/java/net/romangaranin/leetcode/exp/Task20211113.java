package net.romangaranin.leetcode.exp;

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

        System.out.println(s.getFibonacci(0) + " vs 0");
        System.out.println(s.getFibonacci(1) + " vs 1");
        System.out.println(s.getFibonacci(2) + " vs 1");
        System.out.println(s.getFibonacci(3) + " vs 2");
        System.out.println(s.getFibonacci(4) + " vs 3");
        System.out.println(s.getFibonacci(5) + " vs 5");
        System.out.println(s.getFibonacci(6) + " vs 8");
        System.out.println(s.getFibonacci(7) + " vs 13");

        System.out.println();
        System.out.println(s.getFibonacciRec(0) + " vs 0");
        System.out.println(s.getFibonacciRec(1) + " vs 1");
        System.out.println(s.getFibonacciRec(2) + " vs 1");
        System.out.println(s.getFibonacciRec(3) + " vs 2");
        System.out.println(s.getFibonacciRec(4) + " vs 3");
        System.out.println(s.getFibonacciRec(5) + " vs 5");
        System.out.println(s.getFibonacciRec(6) + " vs 8");
        System.out.println(s.getFibonacciRec(7) + " vs 13");
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
        public int getFibonacci(int index) {
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

        public int getFibonacciRec(int index) {
            var memo = new int[index + 1];
            for (int i = 0; i <= index; i++) {
                memo[i] = -1;
            }

            return getFibonacciRecWithMemo(index, memo);
        }

        private int getFibonacciRecWithMemo(int index,
                                            int[] memo) {
            if (index < 2) {
                return index;
            }

            if (memo[index] == -1) {
                memo[index] = getFibonacciRecWithMemo(index - 2, memo) + getFibonacciRecWithMemo(index - 1, memo);
            }

            return memo[index];
        }

    }
}
