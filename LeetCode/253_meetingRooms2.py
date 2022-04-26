"""
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:
    1 <= intervals.length <= 10^4
    0 <= starti < endi <= 10^6
"""
from typing import List

import common


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        result = 0

        timeline = []
        for interval in intervals:
            timeline.append((interval[0], True))
            timeline.append((interval[1], False))
        timeline.sort()

        stack = []
        for event in timeline:
            if event[1]:
                stack.append(event[1])
                result = max(result, len(stack))
            else:
                stack.pop()

        return result


if __name__ == '__main__':
    s = Solution()
    common.assert_equal(s.minMeetingRooms([[0, 30], [5, 10], [15, 20]]), 2)
    common.assert_equal(s.minMeetingRooms([[7, 10], [2, 4]]), 1)
