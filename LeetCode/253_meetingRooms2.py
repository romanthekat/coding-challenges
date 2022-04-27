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
import heapq
from typing import List

import common


class SolutionOrdering:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        starts = []
        ends = []

        for interval in intervals:
            starts.append(interval[0])
            ends.append(interval[1])

        starts.sort()
        ends.sort()

        start_idx = 0
        end_idx = 0

        result = 0
        while start_idx < len(intervals):
            if starts[start_idx] >= ends[end_idx]:
                result -= 1
                end_idx += 1

            result += 1
            start_idx += 1

        return result


class SolutionPriorityQueue:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[0])

        free_rooms = [intervals[0][1]]

        for interval in intervals[1:]:
            if interval[1] >= free_rooms[0]:
                heapq.heappop(free_rooms)

            heapq.heappush(free_rooms, interval[1])

        return len(free_rooms)


class SolutionOriginal:
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
    s = SolutionOrdering()
    common.assert_equal(s.minMeetingRooms([[0, 30], [5, 10], [15, 20]]), 2)
    common.assert_equal(s.minMeetingRooms([[7, 10], [2, 4]]), 1)
