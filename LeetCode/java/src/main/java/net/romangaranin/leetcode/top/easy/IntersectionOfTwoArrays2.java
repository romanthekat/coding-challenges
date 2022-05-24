package net.romangaranin.leetcode.top.easy;

import java.util.ArrayList;
import java.util.HashMap;

import static net.romangaranin.leetcode.Helper.testArrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        var s = new Solution();

        testArrays(s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2, 2});
        testArrays(s.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{9, 4});
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            var resultList = new ArrayList<Integer>();

            var map = new HashMap<Integer, Integer>();
            for (int num : nums1) {
                map.compute(num, (number, count) -> count == null ? 1 : count + 1);
            }
            for (int num : nums2) {
                var value = map.getOrDefault(num, 0);
                if (value > 0) {
                    map.put(num, value - 1);
                    resultList.add(num);
                }
            }

            var result = new int[resultList.size()];
            for (var i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }
    }
}
