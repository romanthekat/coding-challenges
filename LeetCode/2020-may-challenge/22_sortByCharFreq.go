package main

import "fmt"
import "sort"

func main() {
	assert(frequencySort("tree"), "eetr")
	assert(frequencySort("cccaaa"), "ccaaa")
	assert(frequencySort("Aabb"), "bbaA")
	assert(frequencySort("loveleetcode"), " eeeeoollvtdc")
	assert(frequencySort("\"Mymommaalwayssaid,\\\"Lifewaslikeaboxofchocolates.Youneverknowwhatyou'regonnaget.\""), "\"aaaaaaaaaoooooooooeeeeeeennnnsssswwwwlllmmmiiitttyyy..hhffrrkkgguuccMvbL\\\"Y,x'd\"")
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

type SortByFreq []rune

func (s SortByFreq) Len() int {
	return len(s)
}

func (s SortByFreq) Less(i, j int) bool {
	first := s[i]
	second := s[j]

	//enforce same freq but diff chars be separated
	if freqs[first] == freqs[second] && first != second {
		return freqs[first]+int(first) < freqs[second]+int(second)
	}

	return freqs[first] < freqs[second]
}

func (s SortByFreq) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

var freqs map[rune]int

func frequencySort(s string) string {
	freqs = make(map[rune]int)
	for _, char := range s {
		freqs[char]++
	}

	sorted := SortByFreq(s)
	sort.Sort(sort.Reverse(sorted))

	return string(sorted)
}
