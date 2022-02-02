package main

import "fmt"

/**
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
func main() {
	assert(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func maxArea(height []int) int {
	maxArea := 0

	for i := 0; i < len(height)-1; i++ {
		for j := i + 1; j < len(height); j++ {
			area := (j - i) * min(height[i], height[j])
			if area > maxArea {
				maxArea = area
			}
		}

	}

	return maxArea
}

func min(first, second int) int {
	if first < second {
		return first
	} else {
		return second
	}
}
