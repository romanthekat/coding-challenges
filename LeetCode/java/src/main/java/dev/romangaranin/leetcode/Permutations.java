package dev.romangaranin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            var result = new ArrayList<List<Integer>>();
            permute(result, nums, new ArrayList<>());
            return result;
        }

        protected void permute(List<List<Integer>> result, int[] nums, List<Integer> state) {
            if (state.size() == nums.length) {
                result.add(new ArrayList<>(state));
            } else {
                for (int num : nums) {
                    if (state.contains(num)) { //worth using set, for exchange of memory
                        continue;
                    }

                    state.add(num);
                    permute(result, nums, state);
                    state.remove(state.size() - 1);
                }
            }
        }
    }
}
