package main

import (
	"github.com/romanthekat/coding-challenges/LeetCode/common"
)

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/
func main() {
	common.AssertEqual(minPathSum([][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}), 7)
	common.AssertEqual(minPathSum([][]int{{1, 2, 3}, {4, 5, 6}}), 12)
}

func minPathSum(grid [][]int) int {
	var paths [][]int
	for _, line := range grid {
		paths = append(paths, make([]int, len(line)))
	}

	paths[0][0] = grid[0][0]
	maxY := len(grid)
	maxX := len(grid[0])

	for i := 1; i < maxY; i++ {
		paths[i][0] = grid[i][0] + paths[i-1][0]
	}

	for j := 1; j < maxX; j++ {
		paths[0][j] = grid[0][j] + paths[0][j-1]
	}

	for i := 1; i < maxY; i++ {
		for j := 1; j < maxX; j++ {
			paths[i][j] = grid[i][j] + common.Min(paths[i-1][j], paths[i][j-1])
		}
	}

	return paths[maxY-1][maxX-1]
}
