package net.romangaranin.leetcode.top.easy;


import net.romangaranin.leetcode.Helper;

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
        Helper.testCharArrays(inputOdd, new char[]{'o', 'l', 'l', 'e', 'h'});

        var inputEven = new char[]{'h', 'e', 'l', 'l'};
        s.reverseString(inputEven);
        Helper.testCharArrays(inputEven, new char[]{'l', 'l', 'e', 'h'});

        var input0 = new char[]{};
        s.reverseString(input0);
        Helper.testCharArrays(input0, new char[]{});

        var input1 = new char[]{'h'};
        s.reverseString(input1);
        Helper.testCharArrays(input1, new char[]{'h'});

        var input2 = new char[]{'h', 'e'};
        s.reverseString(input2);
        Helper.testCharArrays(input2, new char[]{'e', 'h'});
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
