"""
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces.
"""
from common import assert_equal


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0

        memo = {}
        start_idx = 0
        for idx, c in enumerate(s):
            if c in memo:
                start_idx = max(start_idx, memo[c] + 1)
            memo[c] = idx

            result = max(result, idx - start_idx + 1)

        return result


if __name__ == '__main__':
    s = Solution()

    assert_equal(s.lengthOfLongestSubstring("abcabcbb"), 3)
    assert_equal(s.lengthOfLongestSubstring("pwwkew"), 3)
    assert_equal(s.lengthOfLongestSubstring("bbbb"), 1)
    assert_equal(s.lengthOfLongestSubstring("abba"), 2)
