package dev.romangaranin.leetcode.top.easy;


import static dev.romangaranin.leetcode.Helper.testCharArrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {
    public static void main(String[] args) {
        var s = new Solution();

        var inputOdd = new char[]{'h', 'e', 'l', 'l', 'o'};
        s.reverseString(inputOdd);
        testCharArrays(inputOdd, new char[]{'o', 'l', 'l', 'e', 'h'});

        var inputEven = new char[]{'h', 'e', 'l', 'l'};
        s.reverseString(inputEven);
        testCharArrays(inputEven, new char[]{'l', 'l', 'e', 'h'});

        var input0 = new char[]{};
        s.reverseString(input0);
        testCharArrays(input0, new char[]{});

        var input1 = new char[]{'h'};
        s.reverseString(input1);
        testCharArrays(input1, new char[]{'h'});

        var input2 = new char[]{'h', 'e'};
        s.reverseString(input2);
        testCharArrays(input2, new char[]{'e', 'h'});
    }

    static class Solution {
        public void reverseString(char[] s) {
            if (s.length < 2) {
                return;
            }

            var i = 0;
            var j = s.length - 1;
            while (i < j) {
                var left = s[i];
                var right = s[j];

                s[i] = right;
                s[j] = left;

                i++;
                j--;
            }
        }
    }
}
