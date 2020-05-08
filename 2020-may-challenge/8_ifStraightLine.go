package main

import "C"
import "fmt"

func main() {
	assert(checkStraightLine([][]int{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}), true)
	assert(checkStraightLine([][]int{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}), false)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func checkStraightLine(coordinates [][]int) bool {
	if len(coordinates) == 2 {
		return true
	}

	startX, startY := coordinates[0][0], coordinates[0][1]
	lastPointNum := len(coordinates) - 1
	endX, endY := coordinates[lastPointNum][0], coordinates[lastPointNum][1]

	for i := 1; i < lastPointNum-1; i++ {
		if !checkInLine(startX, coordinates[i][0], endX, startY, coordinates[i][1], endY) {
			return false
		}
	}

	return true
}

func checkInLine(x1, x2, x3, y1, y2, y3 int) bool {
	if x1 == x3 {
		return x2 == x3
	}
	if y1 == y3 {
		return y2 == y3
	}

	return (x2-x1)*(y3-y1) == (x3-x1)*(y2-y1)
}
