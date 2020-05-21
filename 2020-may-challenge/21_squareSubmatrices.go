package main

import "fmt"

func main() {
	matrix15 := [][]int{
		{0, 1, 1, 1},
		{1, 1, 1, 1},
		{0, 1, 1, 1},
	}
	assert(countSquares(matrix15), 15)

	matrix7 := [][]int{
		{1, 0, 1},
		{1, 1, 0},
		{1, 1, 0},
	}
	assert(countSquares(matrix7), 7)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", got == want, got, want)
}

func countSquares(matrix [][]int) int {
	result := 0

	rows := len(matrix)
	columns := len(matrix[0])

	for row := 0; row < rows; row++ {
		for column := 0; column < columns; column++ {
			if matrix[row][column] == 1 {
				if row == 0 || column == 0 {
					result++
				} else {
					matrix[row][column] += min3(matrix[row-1][column-1], matrix[row-1][column], matrix[row][column-1])
					result += matrix[row][column]
				}
			}
		}
	}

	return result
}

func min3(i, j, k int) int {
	return min(min(i, j), k)
}

func min(i, j int) int {
	if i <= j {
		return i
	} else {
		return j
	}
}
