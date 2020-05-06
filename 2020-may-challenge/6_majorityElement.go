package main

import "fmt"

func main() {
	assert(majorityElement([]int{3, 2, 3}), 3)
	assert(majorityElement([]int{2, 2, 1, 1, 1, 2, 2}), 2)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func majorityElement(nums []int) int {
	freqMap := make(map[int]int) //alternatively: array of ten elements; or rely on input sorting

	for _, num := range nums {
		freqMap[num]++
	}

	for num, freq := range freqMap {
		if freq > len(nums)/2 {
			return num
		}
	}

	return -1
}
