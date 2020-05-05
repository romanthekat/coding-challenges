package main

import "fmt"

func main() {
	assert(firstUniqChar("leetcode"), 0)
	assert(firstUniqChar("loveleetcode"), 2)
	assert(firstUniqChar("aabbcc"), -1)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func firstUniqChar(s string) int {
	chars := make(map[rune]int)

	for _, r := range s {
		chars[r]++
	}

	for pos, r := range s {
		if chars[r] == 1 {
			return pos
		}
	}

	return -1
}
