"""
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false



Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 200
    1 <= word.length <= 10^3
    board and word consists only of lowercase and uppercase English letters.
"""
from typing import List

from common import assert_equal


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(word) > len(board) * len(board[0]):
            return False

        for x in range(0, len(board)):
            for y in range(0, len(board[0])):
                if board[x][y] == word[0] and self.word_found(board, word, x, y):
                    return True

        return False

    def word_found(self, board, word, x, y):
        if len(word) == 0:
            return True

        if self.bad_coordinate(board, x, y) or word[0] != board[x][y]:
            return False

        tmp = board[x][y]
        board[x][y] = '@'

        result = self.word_found(board, word[1:], x + 1, y) \
                 or self.word_found(board, word[1:], x - 1, y) \
                 or self.word_found(board, word[1:], x, y + 1) \
                 or self.word_found(board, word[1:], x, y - 1)
        board[x][y] = tmp

        return result

    def bad_coordinate(self, board, x, y):
        return x < 0 or x >= len(board) or y < 0 or y >= len(board[0])


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.exist([["A", "B", "C", "E"],
                          ["S", "F", "C", "S"],
                          ["A", "D", "E", "E"]], "ABCCED"), True)
    assert_equal(s.exist([["A", "B", "C", "E"],
                          ["S", "F", "C", "S"],
                          ["A", "D", "E", "E"]], "SEE"), True)
    assert_equal(s.exist([["A", "B", "C", "E"],
                          ["S", "F", "C", "S"],
                          ["A", "D", "E", "E"]], "ABCB"), False)

    assert_equal(s.exist([["A", "B", "C", "E"],
                          ["S", "F", "E", "S"],
                          ["A", "D", "E", "E"]], "ABCESEEEFS"), True)

    assert_equal(s.exist([["a", "a", "a", "a"],
                          ["a", "a", "a", "a"],
                          ["a", "a", "a", "a"]], "aaaaaaaaaaaaa"), False)

    assert_equal(s.exist([["a", "b", "b", "a", "b"],
                          ["a", "a", "b", "b", "a"],
                          ["a", "a", "a", "a", "b"],
                          ["a", "a", "a", "b", "a"],
                          ["a", "a", "a", "a", "a"],
                          ["a", "b", "a", "b", "b"],
                          ["a", "b", "b", "a", "b"]], "abbbbaababaa"), False)
