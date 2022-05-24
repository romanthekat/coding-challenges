package net.romangaranin.leetcode.top.easy;

import static net.romangaranin.leetcode.Helper.test;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 * <p>
 * Constraints:
 * <p>
 * The input must be a binary string of length 32.
 * <p>
 * <p>
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.hammingWeight(1), 1);
        test(s.hammingWeight(11), 3);
    }

    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            var result = 0;

            //edge case of maximum possible unsinged value gonna look like Integer.MIN
            //-> use n != 0, not n > 0 as if it would be in truly unsigned input
            while (n != 0) {
                result += (n & 1);
                n = n >>> 1;
            }

            return result;
        }
    }
}
