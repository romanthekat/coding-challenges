package main

import "github.com/EvilKhaosKat/coding-challenges/LeetCode/golang/common"

/**
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	sFreqs := getFreqs(s)
	tFreqs := getFreqs(t)

	for r, sFreq := range sFreqs {
		tFreq, ok := tFreqs[r]
		if !ok || tFreq != sFreq {
			return false
		}
	}

	return true
}

func getFreqs(s string) map[rune]int {
	words := make(map[rune]int)
	for _, r := range s {
		words[r] += 1
	}
	return words
}

func main() {
	common.AssertEqual(isAnagram("anagram", "nagaram"), true)
	common.AssertEqual(isAnagram("rat", "car"), false)
	common.AssertEqual(isAnagram("aacc", "ccac"), false)
}
