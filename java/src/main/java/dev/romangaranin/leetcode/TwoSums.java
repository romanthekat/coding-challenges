package dev.romangaranin.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
class TwoSums {
    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();

        validateEqual(twoSums.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }

    public int[] twoSum(int[] nums, int target) {
        int inputLength = nums.length;

        for (int firstIndex = 0; firstIndex < inputLength - 1; firstIndex++) {
            int first = nums[firstIndex];

            for (int secondIndex = firstIndex + 1; secondIndex < inputLength; secondIndex++) {
                int second = nums[secondIndex];

                if ((first + second) == target) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }

        throw new RuntimeException(String.format("Target cannot be satisfied for input:%s , target %s",
                Arrays.toString(nums),
                target));
    }

    protected static void validateEqual(Object actual, Object expected) {
        if (actual instanceof Array) {
            System.out.println("actual value = " + Arrays.toString((Object[]) actual));
        } else {
            System.out.println("actual value = " + actual);
        }

        System.out.println("equal to expected = " + Objects.deepEquals(actual, expected));
    }
}