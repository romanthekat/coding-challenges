package main

import "fmt"

func main() {
	fmt.Printf("must be 3, got: %v\n", numJewelsInStones("aA", "aAAbbbb"))
	fmt.Printf("must be 0, got: %v\n", numJewelsInStones("z", "ZZ"))
}

func numJewelsInStones(J string, S string) int {
	jewels := getJewelsSet(J)

	result := 0

	for _, stone := range []rune(S) {
		if jewels[stone] {
			result++
		}
	}

	return result
}

func getJewelsSet(jewels string) map[rune]bool {
	set := make(map[rune]bool)

	for _, jewel := range []rune(jewels) {
		set[jewel] = true
	}

	return set
}
