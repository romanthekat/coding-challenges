package dev.romangaranin.leetcode.challenge.may2020;

/**
 * == day 1: First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * [source]
 * ----
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 * ----
 */
public class day1_firstBadVersion {
    public static void main(String[] args) {
        check(4, new Solution(4).firstBadVersion(5));
        check(4, new Solution(4).firstBadVersion(6));
        check(3, new Solution(3).firstBadVersion(6));
    }

    protected static void check(int want, int actual) {
        System.out.printf("want: %s, actual: %s\n", want, actual);
    }

    static class Solution {
        private int badVersion;

        public Solution(int badVersion) {
            this.badVersion = badVersion;
        }

        public int firstBadVersion(int versionCount) {
            int min = 0;
            int max = versionCount;

            while (min < max) {
                int toCheck = (min + max) / 2; //avoid overflow with opening the brackets
                if (isBadVersion(toCheck)) {
                    max = toCheck;
                } else {
                    min = toCheck + 1;
                }
            }

            return min;
        }

        protected boolean isBadVersion(int version) {
            return version >= badVersion;
        }
    }

}
