package main

import (
	"fmt"
	"reflect"
	"sort"
)

func main() {
	assert(kClosest([][]int{{1, 3}, {-2, 2}}, 1), [][]int{{-2, 2}})
	assert(kClosest([][]int{{3, 3}, {5, -1}, {-2, 4}}, 2), [][]int{{3, 3}, {-2, 4}})
	assert(kClosest([][]int{{3, 2}, {7, 7}, {9, -9}, {4, -6}, {-3, -6}}, 4), [][]int{{3, 2}, {-3, -6}, {4, -6}, {7, 7}})
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

//alternatively: keep top element and skip if K already reached and element is bigger than top, works on the flight
//also: 'quick select' for better performance
func kClosest(points [][]int, K int) [][]int {
	sort.Slice(points, func(i int, j int) bool {
		return getDist(points[i]) < getDist(points[j])
	})
	return points[:K]
}

func getDist(point []int) int {
	return point[0]*point[0] + point[1]*point[1] //no reasons for extra sqrt
}
