"""
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

1 -
2 abc
3 def
4 ghi
5 jkl
6 mno
7 pqrs
8 tuv
9 wxyz
0 -


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
"""
from typing import List

import common


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {"2": "abc", "3": "def",
                   "4": "ghi", "5": "jkl", "6": "mno",
                   "7": "pqrs", "8": "tuv", "9": "wxyz"}

        result = []
        self._backtracking(mapping, result, digits, 0, "")
        return result

    def _backtracking(self, mapping, result: List, digits: str, index, combination):
        if index == len(digits):
            if len(combination) > 0:
                result.append(combination)
            return

        letters = mapping[digits[index]]
        for letter in letters:
            self._backtracking(mapping, result, digits, index + 1, combination + letter)


if __name__ == "__main__":
    s = Solution()

    common.assert_equal(s.letterCombinations("23"), ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"])
    common.assert_equal(s.letterCombinations("2"), ["a", "b", "c"])
    common.assert_equal(s.letterCombinations(""), [])
