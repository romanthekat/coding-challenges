package main

import "fmt"

func main() {
	image := [][]int{
		{0, 0, 0},
		{0, 1, 1},
		{0, 0, 1},
	}

	resultImage := [][]int{
		{0, 0, 0},
		{0, 2, 2},
		{0, 0, 2},
	}

	assert(floodFill(image, 1, 2, 2), resultImage)

	testImage := [][]int{
		{0, 0, 0},
		{0, 1, 1},
	}
	floodFill(testImage, 1, 1, 1) //check recursive case
}

func assert(got, want interface{}) {
	fmt.Printf("got:\n %t\n want:\n %t\n", got, want)
}

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	if image[sr][sc] == newColor {
		return image
	}

	return floodFillRecursive(image, sr, sc, image[sr][sc], newColor)
}

func floodFillRecursive(image [][]int, sr int, sc int, origColor, newColor int) [][]int {
	if !isCorrectCoordinate(image, sr, sc) || image[sr][sc] != origColor {
		return image
	}

	image[sr][sc] = newColor

	floodFillRecursive(image, sr+1, sc, origColor, newColor)
	floodFillRecursive(image, sr-1, sc, origColor, newColor)
	floodFillRecursive(image, sr, sc+1, origColor, newColor)
	return floodFillRecursive(image, sr, sc-1, origColor, newColor)
}

func isCorrectCoordinate(image [][]int, sr int, sc int) bool {
	return sr >= 0 && sr < len(image) && sc >= 0 && sc < len(image[0])
}
