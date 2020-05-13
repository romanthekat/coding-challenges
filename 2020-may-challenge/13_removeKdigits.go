package main

import "fmt"

func main() {
	assert(removeKdigits("1432219", 3), "1219")
	assert(removeKdigits("10200", 1), "200")
	assert(removeKdigits("10", 2), "0")
	assert(removeKdigits("10", 1), "0")
	assert(removeKdigits("9", 1), "0")
	assert(removeKdigits("1432219", 3), "1219")
}

func assert(got, want interface{}) {
	fmt.Printf("%t|got: %t, want: %t\n", got == want, got, want)
}

func removeKdigits(num string, k int) string {
	runes := []rune(num)

	for removed := 0; removed < k; removed++ {
		i := 0
		for i < len(runes)-1 {
			if runes[i] <= runes[i+1] {
				i++
			} else {
				break
			}
		}
		runes = append(runes[:i], runes[i+1:]...)
	}

	startRange := 0
	for i, num := range runes {
		if num == '0' {
			startRange = i + 1
		} else {
			break
		}
	}

	result := string(runes[startRange:])

	if len(result) == 0 {
		return "0"
	}

	return result
}
