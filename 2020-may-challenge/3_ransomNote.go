package main

import "fmt"

func main() {
	assert(canConstruct("a", "b"), false)
	assert(canConstruct("aa", "ab"), false)
	assert(canConstruct("aa", "aab"), true)
}

func assert(got, want bool) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func canConstruct(ransomNote string, magazine string) bool {
	letters := make(map[rune]int) //can be optimized with array of 26 letters
	for _, letter := range []rune(magazine) {
		if _, ok := letters[letter]; ok {
			letters[letter]++
		} else {
			letters[letter] = 1
		}
	}

	for _, ransomLetter := range []rune(ransomNote) {
		if amount, ok := letters[ransomLetter]; ok && amount > 0 {
			letters[ransomLetter]--
		} else {
			return false
		}
	}

	return true
}