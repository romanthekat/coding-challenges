package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(maxUncrossedLines([]int{1, 4, 2}, []int{1, 2, 4}), 2)
	assert(maxUncrossedLines([]int{2, 5, 1, 2, 5}, []int{10, 5, 2, 1, 5, 2}), 3)
	assert(maxUncrossedLines([]int{1, 3, 7, 1, 7, 5}, []int{1, 9, 2, 5, 1}), 2)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func maxUncrossedLines(a []int, b []int) int {
	return lcs(a, b, len(a), len(b))
}

func lcs(a []int, b []int, i, j int) int {
	if i == 0 || j == 0 {
		return 0
	} else if a[i-1] == b[j-1] {
		return 1 + lcs(a, b, i-1, j-1)
	} else {
		return max(lcs(a, b, i, j-1), lcs(a, b, i-1, j))
	}
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
