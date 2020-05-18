package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(checkInclusion("ab", "eidbaooo"), true)
	assert(checkInclusion("ab", "eidboaoo"), false)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

func checkInclusion(s1 string, s2 string) bool {
	targetArray := make([]int, 26)
	currentArray := make([]int, 26)

	for i := range s1 {
		targetArray[s1[i]-'a']++
	}

	for i := range s2 {
		if i >= len(s1) {
			currentArray[s2[i-len(s1)]-'a']--
		}

		currentArray[s2[i]-'a']++

		if reflect.DeepEqual(targetArray, currentArray) { //alternatively: manually check it's equality
			return true
		}
	}

	return false
}
