package dev.romangaranin.leetcode;

import java.util.*;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * <p>
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public static void main(String[] args) {
        test(new Solution().ladderLength("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log", "cog")),
                5);
        test(new Solution().ladderLength("aaa", "bbb",
                List.of("aab", "abb", "aba", "bbb")),
                4);
        test(new Solution().ladderLength("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log")),
                0);
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            var words = new HashSet<>(wordList);

            var visited = new HashSet<String>();
            var toCheck = new ArrayDeque<String>();
            toCheck.add(beginWord);

            var len = 1;
            while (!toCheck.isEmpty()) {
                var levelSize = toCheck.size();

                for (var l = 0; l < levelSize; l++) {
                    var word = toCheck.pop();
                    if (Objects.equals(word, endWord)) {
                        return len;
                    }

                    visited.add(word);

                    for (var i = 0; i < word.length(); i++) {
                        var wordArray = word.toCharArray();
                        for (var c = 'a'; c <= 'z'; c++) {
                            wordArray[i] = c;
                            var newWord = String.valueOf(wordArray);
                            if (words.contains(newWord) && !visited.contains(newWord)) {
                                toCheck.addLast(newWord);
                            }
                        }
                    }
                }

                len++;
            }

            return 0;
        }
    }
}
