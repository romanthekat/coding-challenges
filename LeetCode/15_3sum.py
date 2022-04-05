"""
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:

    0 <= nums.length <= 3000
    -10^5 <= nums[i] <= 10^5
"""

from typing import List

from common import assert_equal


class SolutionSet:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []

        nums = sorted(nums)

        for i in range(len(nums)):
            if nums[i] > 0:
                break

            if i != 0 and nums[i] == nums[i - 1]:
                continue

            seen = set()
            j = i + 1
            while j < len(nums):
                target_num = - nums[i] - nums[j]
                if target_num in seen:
                    result.append([nums[i], nums[j], target_num])
                    while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                        j += 1

                seen.add(nums[j])
                j += 1

        return result


class SolutionTwoPointers:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []

        nums = sorted(nums)

        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i != 0 and nums[i - 1] == nums[i]:
                continue

            left = i + 1
            right = len(nums) - 1

            while left < right:
                sum = nums[i] + nums[left] + nums[right]

                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1

                    while left < right and nums[left - 1] == nums[left]:
                        left += 1

        return result


if __name__ == '__main__':
    s = SolutionTwoPointers()

    assert_equal(s.threeSum([-1, 0, 1, 2, -1, -4]), [[-1, -1, 2], [-1, 0, 1]])
    assert_equal(s.threeSum([0, 0, 0]), [[0, 0, 0]])
    assert_equal(s.threeSum([0, 0, 0, 0]), [[0, 0, 0]])
    assert_equal(s.threeSum([-2, 0, 1, 1, 2]), [[-2, 0, 2], [-2, 1, 1]])
