import java.util.Arrays;

/**
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

        int[] result = twoSums.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.equals(result, new int[]{0, 1}));
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
}