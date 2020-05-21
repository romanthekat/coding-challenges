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
	maxSide := getMaxSide(matrix)

	result := 0
	for side := 1; side <= maxSide; side++ {
		for y := 0; y <= len(matrix)-side; y++ {
			for x := 0; x <= len(matrix[0])-side; x++ {
				if isSquareSubmatrix(matrix, x, y, side) {
					result++
				}
			}
		}
	}

	return result
}

func isSquareSubmatrix(matrix [][]int, startX int, startY int, side int) bool {
	if (startX+side > len(matrix[0])) || (startY+side > len(matrix)) {
		return false
	}

	for x := startX; x < startX+side; x++ {
		for y := startY; y < startY+side; y++ {
			if matrix[y][x] != 1 {
				return false
			}
		}
	}

	return true
}

func getMaxSide(matrix [][]int) int {
	rows := len(matrix)
	columns := len(matrix[0])

	if rows < columns {
		return rows
	} else {
		return columns
	}
}
