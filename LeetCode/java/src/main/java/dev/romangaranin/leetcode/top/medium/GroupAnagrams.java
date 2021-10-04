package dev.romangaranin.leetcode.top.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        var s = new Solution();

        test(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")));

        test(s.groupAnagrams(new String[]{""}), List.of(List.of("")));
        test(s.groupAnagrams(new String[]{"a"}), List.of(List.of("a")));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            var groups = new HashMap<String, List<String>>();

            for (var str : strs) {
                var chars = str.toCharArray();
                Arrays.sort(chars);
                var sortedString = new String(chars);

                var group = groups.getOrDefault(sortedString, new ArrayList<>());
                group.add(str);
                groups.put(sortedString, group);
            }

            return new ArrayList<>(groups.values());
        }
    }

}
