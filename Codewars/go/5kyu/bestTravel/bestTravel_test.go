package kata

import (
	"fmt"
	"testing"
)

func doTest(t *testing.T, maxDistance, townsCount int, ls []int, correctResult int) {
	var actualResult = ChooseBestSum(maxDistance, townsCount, ls)

	if actualResult != correctResult {
		t.Error(fmt.Printf("expected '%v', but got '%v'\n", correctResult, actualResult))
	}
}

func TestBestTravel(t *testing.T) {
	var ts = []int{50, 55, 56, 57, 58}
	doTest(t, 163, 3, ts, 163)

	ts = []int{50}
	doTest(t, 163, 3, ts, -1)

	ts = []int{91, 74, 73, 85, 73, 81, 87}
	doTest(t, 230, 3, ts, 228)
	doTest(t, 331, 2, ts, 178)
	doTest(t, 331, 4, ts, 331)
	doTest(t, 331, 5, ts, -1)
}
