package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(findAnagrams("cbaebabacd", "abc"), []int{0, 6})
	assert(findAnagrams("abab", "ab"), []int{0, 1, 2})
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func findAnagrams(s string, p string) []int {
	var result []int

	targetWordMap := getWordMap(p)

	for i := 0; i <= len(s)-len(p); i++ {
		checkWordMap := getWordMap(s[i : i+len(p)])
		if reflect.DeepEqual(targetWordMap, checkWordMap) {
			result = append(result, i)
		}
	}

	return result
}

func getWordMap(word string) map[rune]int {
	result := make(map[rune]int)
	for _, char := range word {
		result[char]++
	}

	return result
}
