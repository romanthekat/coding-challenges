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
	targetMap := getWordMap(s1)
	for i := 0; i <= len(s2)-len(s1); i++ {
		checkMap := getWordMap(s2[i : i+len(s1)])
		if reflect.DeepEqual(targetMap, checkMap) {
			return true
		}
	}

	return false
}

func getWordMap(word string) map[rune]int {
	result := make(map[rune]int)
	for _, char := range word {
		result[char]++
	}

	return result
}
