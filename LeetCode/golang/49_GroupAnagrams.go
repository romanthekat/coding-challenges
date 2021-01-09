package main

import (
	"fmt"
	"reflect"
)

/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
func main() {
	fmt.Println("want: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]")
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

type Anagram struct {
	word    string
	letters map[rune]int
	group   int
}

func groupAnagrams(strs []string) [][]string {
	var anagrams []Anagram
	var groups [][]string

	for _, word := range strs {
		letters := getLetters(word)

		anagram := findExistingAnagram(anagrams, letters)
		if anagram != nil {
			newAnagram := Anagram{word, letters, anagram.group}
			anagrams = append(anagrams, newAnagram)
			groups[anagram.group] = append(groups[anagram.group], word)
		} else {
			newAnagram := Anagram{word, letters, len(groups)}
			anagrams = append(anagrams, newAnagram)
			groups = append(groups, []string{word})
		}
	}

	return groups
}

func findExistingAnagram(anagrams []Anagram, letters map[rune]int) *Anagram {
	for _, anagram := range anagrams {
		if reflect.DeepEqual(anagram.letters, letters) {
			return &anagram
		}
	}

	return nil
}

func getLetters(word string) map[rune]int {
	letters := make(map[rune]int)

	for _, char := range word {
		letters[char]++
	}

	return letters
}
