package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(maxUncrossedLines([]int{1, 4, 2}, []int{1, 2, 4}), 2)
	assert(maxUncrossedLines([]int{2, 5, 1, 2, 5}, []int{10, 5, 2, 1, 5, 2}), 3)
	assert(maxUncrossedLines([]int{1, 3, 7, 1, 7, 5}, []int{1, 9, 2, 5, 1}), 2)
	assert(maxUncrossedLines([]int{3, 1, 2, 1, 4, 1, 2, 2, 5, 3, 2, 1, 1, 4, 5, 2, 3, 2, 5, 5},
		[]int{2, 4, 1, 2, 3, 4, 2, 4, 5, 5, 1, 1, 2, 1, 1, 1, 5, 4, 1, 4, 2, 1, 5, 4, 2, 3, 1, 5, 2, 1}),
		14)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func maxUncrossedLines(a []int, b []int) int {
	table := make([][]int, len(a)+1)
	for i := 0; i <= len(a); i++ {
		table[i] = make([]int, len(b)+1)
	}

	for i := 1; i <= len(a); i++ {
		for j := 1; j <= len(b); j++ {
			if a[i-1] == b[j-1] {
				table[i][j] = table[i-1][j-1] + 1
			} else {
				table[i][j] = max(table[i][j-1], table[i-1][j])
			}
		}
	}

	return table[len(a)][len(b)]
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
