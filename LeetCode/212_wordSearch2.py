"""
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []



Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 12
    board[i][j] is a lowercase English letter.
    1 <= words.length <= 3 * 10^4
    1 <= words[i].length <= 10
    words[i] consists of lowercase English letters.
    All the strings of words are unique.
"""
from typing import List

import common


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        result = set()

        words_set = set(words)
        max_y = len(board)
        max_x = len(board[0])
        max_word_len = len(max(words, key=lambda word: len(word)))

        def _backtracking(y, x, word, used):
            if word in words_set:
                result.add(word)

            if len(word) >= max_word_len:
                return

            candidates = []
            for delta_y, delta_x in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                cand_y = y + delta_y
                cand_x = x + delta_x
                if 0 <= cand_y < max_y and 0 <= cand_x < max_x and not used[cand_y][cand_x]:
                    candidates.append((word + board[cand_y][cand_x], (cand_y, cand_x)))

            for candidate, coor in candidates:
                used[coor[0]][coor[1]] = True
                _backtracking(coor[0], coor[1], candidate, used)
                used[coor[0]][coor[1]] = False

        for y in range(max_y):
            for x in range(max_x):
                _backtracking(y, x, board[y][x], self._get_used(max_y, max_x, y, x))

        return list(result)

    def _get_used(self, max_y, max_x, y, x):
        used = [[False for _ in range(max_x)] for _ in range(max_y)]
        used[y][x] = True
        return used


if __name__ == '__main__':
    s = Solution()

    common.assert_equal(s.findWords([["o", "a", "a", "n"],
                                     ["e", "t", "a", "e"],
                                     ["i", "h", "k", "r"],
                                     ["i", "f", "l", "v"]],
                                    ["oath", "pea", "eat", "rain"]),
                        ["oath", "eat"])

    common.assert_equal(s.findWords([["a", "b"], ["c", "d"]], ["abcb"]),
                        [])

    common.assert_equal(
        s.findWords([["o", "a", "b", "n"],
                     ["o", "t", "a", "e"],
                     ["a", "h", "k", "r"],
                     ["a", "f", "l", "v"]],
                    ["oa", "oaa"]),
        ["oa", "oaa"])

    common.assert_equal(s.findWords([["a", "b"]], ["ab"]),
                        ["ab"])

    common.assert_equal(s.findWords([["a", "a"]], ["aaa"]),
                        [])

    common.assert_equal(s.findWords([["a", "b", "c", "e"],
                                     ["x", "x", "c", "d"],
                                     ["x", "x", "b", "a"]],
                                    ["abc", "abcd"]),
                        ["abc", "abcd"])
