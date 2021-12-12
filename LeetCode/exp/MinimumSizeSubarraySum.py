# iterate

# Input: target = 7, nums = [2,3,1,2,4,3]
# Output: 2
# Time: O(n), mem O(1)


class Solution:
    def min_subarray_sum(self, nums, target) -> int:
        result = float('inf')
        sum = 0
        window_start_idx = 0

        for idx, num in enumerate(nums):
            sum += num

            while sum >= target:
                result = min(result, idx - window_start_idx + 1)
                sum -= nums[window_start_idx]
                window_start_idx += 1

        return result


print(Solution().min_subarray_sum([2, 3, 1, 2, 4, 3], 7))
print(Solution().min_subarray_sum([1, 4, 4], 4))
print(Solution().min_subarray_sum([1, 1, 1, 1, 1, 1, 1, 1], 11))
