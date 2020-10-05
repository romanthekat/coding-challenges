package kata

import (
	"fmt"
	"testing"
)

//tests pile of cubes height calculation
func TestPileOfCubes(t *testing.T) {
	checkCorrect(t, 4183059834009, 2022)
	checkCorrect(t, 24723578342962, -1)
}

func TestPileOfCubesInstructions(t *testing.T) {
	checkCorrect(t, 1071225, 45)
}

func TestPileOfCubesLapushka(t *testing.T) {
	checkCorrect(t,9541025211025, 2485)
	checkCorrect(t,1939115155982364801, 52773)
	checkCorrect(t,4183059834009, 2022)
	checkCorrect(t,24723578342962, -1)
	checkCorrect(t,135440716410000, 4824)
	checkCorrect(t,40539911473216, 3568)
}

func checkCorrect(t *testing.T, volume, correctResult int) {
	actualResult := FindNb(volume)
	if actualResult != correctResult {
		failTest(t, correctResult, actualResult)
	}
}

func failTest(t *testing.T, correctResult, actualResult int) {
	t.Error(fmt.Printf("Calculated wrong, expected '%v',\n but got '%v'", correctResult, actualResult))
}
