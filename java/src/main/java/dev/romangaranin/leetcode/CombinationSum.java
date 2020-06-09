package dev.romangaranin.leetcode;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    public static void main(String[] args) {
        test(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7), List.of(List.of(7), List.of(2, 2, 3)));
        test(new Solution().combinationSum(new int[]{2, 3, 5}, 8), List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)));
    }

    protected static void test(List<List<Integer>> got, List<List<Integer>> want) {
        var gotSet = new HashSet<>(got);
        var wantSet = new HashSet<>(want);
        var same = Objects.equals(gotSet, wantSet);
        System.out.println(format("%s|got: %s, want: %s", same, got, want));
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            var result = new HashSet<List<Integer>>();
            return combinationSum(result, new ArrayList<>(), 0, candidates, target);
        }

        protected List<List<Integer>> combinationSum(Set<List<Integer>> result,
                                                     List<Integer> state,
                                                     int index,
                                                     int[] candidates,
                                                     int target) {
            var combination = state.stream().reduce(0, Integer::sum);

            if (combination > target || index >= candidates.length) {
                return new ArrayList<>(result);
            } else if (combination == target) {
                result.add(state);
                return new ArrayList<>(result);
            }

            combinationSum(result, state, index + 1, candidates, target);

            var copiedState = new ArrayList<>(state);
            copiedState.add(candidates[index]);
            combinationSum(result, copiedState, index, candidates, target);
            combinationSum(result, copiedState, index + 1, candidates, target);

            return new ArrayList<>(result);
        }
    }
}
