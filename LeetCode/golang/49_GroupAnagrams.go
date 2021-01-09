package main

import (
	"fmt"
	"sort"
)

/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
func main() {
	fmt.Println("want: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]")
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	anagrams := make(map[string][]string)

	for _, word := range strs {
		letters := getLetters(word)

		if group, ok := anagrams[letters]; ok {
			group = append(group, word)
			anagrams[letters] = group
		} else {
			anagrams[letters] = []string{word}
		}
	}

	var groups [][]string

	for _, group := range anagrams {
		groups = append(groups, group)
	}

	return groups
}

func getLetters(word string) string {
	runes := []rune(word)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}
