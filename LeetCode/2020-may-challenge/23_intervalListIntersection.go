package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(intervalIntersection(
		[][]int{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
		[][]int{{1, 5}, {8, 12}, {15, 24}, {25, 26}}),
		[][]int{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}})

	assert(intervalIntersection([][]int{{14, 16}}, [][]int{{7, 13}, {16, 20}}),
		[][]int{{16, 16}})
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func intervalIntersection(A [][]int, B [][]int) [][]int {
	var result [][]int

	aIndex := 0
	bIndex := 0

	for aIndex < len(A) && bIndex < len(B) {
		aEntry := A[aIndex]
		bEntry := B[bIndex]

		if isBetween(bEntry[0], bEntry[1], aEntry[0]) {
			result = append(result, getInterval(bEntry, aEntry))
		} else if isBetween(aEntry[0], aEntry[1], bEntry[0]) {
			result = append(result, getInterval(aEntry, bEntry))
		}

		if aEntry[1] > bEntry[1] {
			bIndex++
		} else {
			aIndex++
		}

	}

	return result
}

func getInterval(start []int, end []int) []int {
	return []int{max(start[0], end[0]), min(start[1], end[1])}
}

func isBetween(start, end, check int) bool {
	return check >= start && check <= end
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}

func min(i, j int) int {
	if i < j {
		return i
	} else {
		return j
	}
}
