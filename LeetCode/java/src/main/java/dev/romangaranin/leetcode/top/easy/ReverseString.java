package dev.romangaranin.leetcode.top.easy;


import static dev.romangaranin.leetcode.Helper.*;

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

            var leftIdx = 0;
            var rightIdx = s.length - 1;
            while (leftIdx < rightIdx) {
                var left = s[leftIdx];
                var right = s[rightIdx];

                s[leftIdx] = right;
                s[rightIdx] = left;

                leftIdx++;
                rightIdx--;
            }
        }
    }
}
