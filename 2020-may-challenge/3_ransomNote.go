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
	if len(ransomNote) > len(magazine) {
		return false
	}

	letters := make(map[rune]int) //can be optimized with array of 26 letters
	for _, letter := range []rune(magazine) {
		letters[letter]++
	}

	for _, ransomLetter := range []rune(ransomNote) {
		if letters[ransomLetter] > 0 {
			letters[ransomLetter]--
		} else {
			return false
		}
	}

	return true
}
