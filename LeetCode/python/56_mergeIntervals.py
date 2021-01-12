"""
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.



Constraints:

    1 <= intervals.length <= 10^4
    intervals[i].length == 2
    0 <= starti <= endi <= 10^4
"""
from typing import List
from common import assert_equal


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])

        result = [intervals.pop(0)]

        for interval in intervals:
            prev_interval = result[-1]

            if prev_interval[1] >= interval[0]:
                prev_interval[1] = max(prev_interval[1], interval[1])
            else:
                result.append(interval)

        return result


if __name__ == '__main__':
    solution = Solution()
    assert_equal(solution.merge([[1, 3], [2, 6], [8, 10], [15, 18]]), [[1, 6], [8, 10], [15, 18]])
    assert_equal(solution.merge([[1, 4], [4, 5]]), [[1, 5]])
    assert_equal(solution.merge([[1, 4]]), [[1, 4]])
    assert_equal(solution.merge([[1, 4], [0, 4]]), [[0, 4]])
