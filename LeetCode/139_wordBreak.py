"""
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
"""
from typing import List

from common import assert_equal


class Trie:
    def __init__(self):
        self.root = Node(None)

    def insert(self, word):
        node = self.root

        for letter in word:
            child = node.children.get(letter)
            if not child:
                child = Node(letter)
                node.children[letter] = child

            node = child

        node.is_word_end = True

    def has_word(self, word) -> bool:
        node = self.root
        for letter in word:
            child = node.children.get(letter)
            if not child:
                return False

            node = child

        return node.is_word_end


class Node:
    def __init__(self, letter):
        self.letter = letter
        self.children = {}
        self.is_word_end = False

    def __str__(self) -> str:
        return f"{self.letter}:{self.is_word_end} {str(self.children)}"


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        breakable = [False] * (len(s) + 1)
        breakable[0] = True
        trie = self._init_trie(wordDict)

        for current_index in range(1, len(s) + 1):
            for prev_index in range(0, current_index):
                if breakable[prev_index] and trie.has_word(s[prev_index:current_index]):
                    breakable[current_index] = True
                    break

        return breakable[len(s)]

    def _init_trie(self, word_dict) -> Trie:
        root = Trie()

        for word in word_dict:
            root.insert(word)

        return root


if __name__ == '__main__':
    s = Solution()
    assert_equal(s.wordBreak("leetcode", ["leet", "code"]), True)
    assert_equal(s.wordBreak("applepenapple", ["apple", "pen"]), True)
    assert_equal(s.wordBreak("catsandog", ["cats", "dog", "sand", "and", "cat"]), False)
    assert_equal(s.wordBreak("aaaaaaa", ["aaaa", "aa"]), False)
    assert_equal(s.wordBreak("aaaaaaa", ["aaaa", "aaa"]), True)
