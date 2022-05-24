package net.romangaranin.leetcode.top.easy;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        var s = new Solution();

        s.badVersion = 4;
        test(s.firstBadVersion(5), s.badVersion);

        s.badVersion = 1;
        test(s.firstBadVersion(1), s.badVersion);

        s.badVersion = 2;
        test(s.firstBadVersion(3), s.badVersion);
    }

    static class VersionControl {
        public int badVersion = 4;

        protected boolean isBadVersion(int version) {
            return version >= badVersion;
        }
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            var left = 0;
            var right = n;

            while (left < right) {
                var mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

}
