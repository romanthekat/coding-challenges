package dev.romangaranin.leetcode;

import java.util.*;

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
        Helper.test(new Solution().ladderLength("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log", "cog")),
                5);
        Helper.test(new Solution().ladderLength("aaa", "bbb",
                List.of("aab", "abb", "aba", "bbb")),
                4);
        Helper.test(new Solution().ladderLength("hit", "cog",
                List.of("hot", "dot", "dog", "lot", "log")),
                0);
    }

    static class Pair {
        String word;
        Integer len;

        public Pair(String word, Integer len) {
            this.word = word;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "word='" + word + '\'' +
                    ", len=" + len +
                    '}';
        }
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            var visited = new HashSet<String>();
            var words = new HashSet<>(wordList);

            var toCheck = new ArrayDeque<Pair>();
            toCheck.add(new Pair(beginWord, 1));

            while (!toCheck.isEmpty()) {
                var entry = toCheck.pop();
                visited.add(entry.word);

                if (Objects.equals(entry.word, endWord)) {
                    return entry.len;
                }

                var wordArray = entry.word.toCharArray();
                for (var i = 0; i < wordArray.length; i++) {
                    var originalChar = wordArray[i];
                    for (var c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        var newWord = String.valueOf(wordArray);
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            toCheck.addLast(new Pair(newWord, entry.len + 1));
                        }
                    }
                    wordArray[i] = originalChar;
                }
            }

            return 0;
        }
    }
}
