package main

import "fmt"

func main() {
	assert(findJudge(2, [][]int{{1, 2}}), 2)
	assert(findJudge(3, [][]int{{1, 3}, {2, 3}}), 3)
	assert(findJudge(3, [][]int{{1, 3}, {2, 3}, {3, 1}}), -1)
	assert(findJudge(3, [][]int{{1, 2}, {2, 3}}), -1)
	assert(findJudge(4, [][]int{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}), 3)
	assert(findJudge(1, [][]int{}), 1)
}

func assert(got, want interface{}) {
	fmt.Printf("got: %t, want: %t\n", got, want)
}

func findJudge(N int, trust [][]int) int {
	trustedBy := make([]int, N)
	trustsTo := make([]int, N)

	for _, trustEntry := range trust {
		who := trustEntry[0] - 1
		to := trustEntry[1] - 1

		trustedBy[to]++
		trustsTo[who]++
	}

	for who, trustedByCount := range trustedBy {
		if trustedByCount == N-1 && trustsTo[who] == 0 {
			return who + 1
		}
	}

	return -1
}
