"""
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true

Constraints:
    0 <= intervals.length <= 10^4
    intervals[i].length == 2
    0 <= starti < endi <= 10^6

"""
from typing import List

import common


class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals.sort(key=lambda x: x[0])

        for i in range(len(intervals) - 1):
            if intervals[i][1] > intervals[i+1][0]:
                return False

        return True


class SolutionOrderingAndRooms:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        starts = []
        ends = []

        for interval in intervals:
            starts.append(interval[0])
            ends.append(interval[1])

        starts.sort()
        ends.sort()

        start_idx = 0
        end_idx = 0

        meeting_rooms = 0
        while start_idx < len(intervals):
            if starts[start_idx] >= ends[end_idx]:
                meeting_rooms -= 1
                end_idx += 1

            meeting_rooms += 1
            start_idx += 1

        return meeting_rooms <= 1


if __name__ == '__main__':
    s = Solution()

    common.assert_equal(s.canAttendMeetings([[0, 30], [5, 10], [15, 20]]), False)
    common.assert_equal(s.canAttendMeetings([[7, 10], [2, 4]]), True)
    common.assert_equal(s.canAttendMeetings([]), True)
