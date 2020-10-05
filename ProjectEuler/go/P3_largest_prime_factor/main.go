package main

import (
	"fmt"
	"math"
)

//using simple factors enumeration algorithm
//	check all natural numbers from 2 to sqrt of n
//      divide number over and over again
func main() {
	number := 600851475143

	var maxPrimeFactor int
	var maxFactorToCheck = getMaxFactorToCheck(number)

	curNumber := number
	for {
		for divider := 2; divider < maxFactorToCheck; divider++ {
			if curNumber%divider == 0 {
				curNumber /= divider
				maxPrimeFactor = divider

				break
			}
		}

		if curNumber == 1 {
			break
		}
	}

	fmt.Printf("maxFactor:%d\n", maxPrimeFactor)
}

func getMaxFactorToCheck(num int) int {
	floatNum := float64(num)
	return int(math.Sqrt(floatNum))
}
