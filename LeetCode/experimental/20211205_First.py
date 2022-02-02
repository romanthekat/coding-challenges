from typing import List


# There are n buildings in a line. You are given an integer array heights of size n that represents the heights of
# the buildings in the line.
#
# The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without
# obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
#
# Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
#
# class Solution:
#    def findBuildings(self, heights: List[int]) -> List[int]:
# Input: heights = [4,2,3,1]
# Output: [0,2,3]
# Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
#
# Input: heights = [4,3,2,1]
# Output: [0,1,2,3]
# Explanation: All the buildings have an ocean view.
#
# Input: heights = [1,3,2,4]
# Output: [3]
# Explanation: Only building 3 has an ocean view.


# iterate, reverse;
# tallest so fast,
# compare
class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        result = []
        tallest = 0

        for index in range(len(heights) - 1, -1, -1):
            height = heights[index]

            if height > tallest:
                result.append(index)
                tallest = height

        return sorted(result)


s = Solution()
print(s.findBuildings([4, 2, 3, 1]))
print(s.findBuildings([4, 3, 2, 1]))
print(s.findBuildings([1, 3, 2, 4]))
