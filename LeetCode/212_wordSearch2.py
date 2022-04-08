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


class SolutionTrie:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        WORD_KEY = "@"

        result = []

        max_row = len(board)
        max_col = len(board[0])

        def get_trie(words: List[str]):
            root = {}
            for word in words:
                node = root
                for letter in word:
                    node = node.setdefault(letter, {})
                node[WORD_KEY] = word
            return root

        trie = get_trie(words)

        def _backtracking(row, col, parent_node):
            letter = board[row][col]
            node = parent_node[letter]

            # side effect - removes word from trie if found
            word_match = node.pop(WORD_KEY, False)
            if word_match:
                result.append(word_match)

            board[row][col] = "#"
            for delta_row, delta_col in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                new_row = row + delta_row
                new_col = col + delta_col

                if not (0 <= new_row < max_row and 0 <= new_col < max_col):
                    continue
                if not (board[new_row][new_col] in node):
                    continue
                _backtracking(new_row, new_col, node)
            board[row][col] = letter

            if len(node) == 0:
                parent_node.pop(letter)

        for row in range(max_row):
            for col in range(max_col):
                if board[row][col] in trie:
                    _backtracking(row, col, trie)

        return result


class SolutionSimple:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        result = set()

        words_set = set(words)
        max_row = len(board)
        max_col = len(board[0])
        max_word_len = len(max(words, key=lambda word: len(word)))

        def _backtracking(row, col, word, used):
            if word in words_set:
                result.add(word)

            if len(word) >= max_word_len:
                return

            for delta_row, delta_col in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                new_row = row + delta_row
                new_col = col + delta_col
                if not (0 <= new_row < max_row and 0 <= new_col < max_col):
                    continue
                if used[new_row][new_col]:
                    continue

                used[new_row][new_col] = True
                _backtracking(new_row, new_col, word + board[new_row][new_col], used)
                used[new_row][new_col] = False

        for row in range(max_row):
            for col in range(max_col):
                _backtracking(row, col, board[row][col], self._get_used(max_row, max_col, row, col))

        return list(result)

    def _get_used(self, max_row, max_col, row, col):
        used = [[False for _ in range(max_col)] for _ in range(max_row)]
        used[row][col] = True
        return used


if __name__ == '__main__':
    s = SolutionTrie()

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
