package net.romangaranin.leetcode;

import java.util.HashMap;

public class Task1TwoSum {
    public static void main(String[] args) {
        var s = new Solution();
        Helper.testArrays(s.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            var numbersSeen = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                var anotherNumber = target - nums[i];
                if (numbersSeen.containsKey(anotherNumber)) {
                    return new int[]{numbersSeen.get(anotherNumber), i};
                }

                numbersSeen.put(nums[i], i);
            }

            System.out.println("there is no solution actually");
            return new int[]{-1, -1};
        }
    }
}
