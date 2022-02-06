"""
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.

"""
from common import assert_equal


class Solution:
    def longestPalindrome(self, s: str) -> str:
        idx_from, idx_to = 0, 0

        for i in range(len(s)):
            len_even = self.__expand_around(s, i, i)
            len_odd = self.__expand_around(s, i, i + 1)

            max_len = max(len_even, len_odd)
            if max_len > idx_to - idx_from:
                idx_from = i - (max_len - 1) // 2
                idx_to = i + max_len // 2

        return s[idx_from:idx_to+1]

    def __expand_around(self, s, idx_from, idx_to) -> int:
        while idx_from >= 0 and idx_to < len(s) and s[idx_from] == s[idx_to]:
            idx_from -= 1
            idx_to += 1

        return idx_to - idx_from - 1


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.longestPalindrome("babad"), "aba")
    assert_equal(s.longestPalindrome("cbbd"), "bb")
