package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(kClosest([][]int{{1, 3}, {-2, 2}}, 1), [][]int{{-2, 2}})
	assert(kClosest([][]int{{3, 3}, {5, -1}, {-2, 4}}, 2), [][]int{{3, 3}, {-2, 4}})
	assert(kClosest([][]int{{3, 2}, {7, 7}, {9, -9}, {4, -6}, {-3, -6}}, 4), [][]int{{3, 2}, {-3, -6}, {4, -6}, {7, 7}})
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func kClosest(points [][]int, K int) [][]int {
	var result [][]int

	for _, point := range points {
		dist := point[0]*point[0] + point[1]*point[1]
		index := 0
		for _, top := range result {
			if dist < top[0]*top[0]+top[1]*top[1] {
				break
			}
			index++
		}

		result = append(result, []int{})
		copy(result[index+1:], result[index:])
		result[index] = []int{point[0], point[1]}
	}

	if len(result) > K {
		return result[:K]
	}
	return result
}
