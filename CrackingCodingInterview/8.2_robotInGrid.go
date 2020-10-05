package main

import (
	"fmt"
	"sort"
)

/**
8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.

upd: 0 - passable. 1 - impassible.
*/

type Point struct {
	x, y int
}

type State struct {
	point   Point
	stepNum int
	checked map[Point]int
}

//TODO usage of pointers will optimize memory allocations
func main() {
	grid := [][]int{
		{0, 0, 0, 0, 0, 0},
		{1, 1, 1, 0, 1, 0},
		{0, 0, 0, 0, 1, 0},
		{0, 0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0},
	}

	startPoint := getStartPoint(grid)
	endPoint := getEndPoint(grid)

	results := findPath(startPoint, endPoint, grid)

	fmt.Printf("results count: %v\n", len(results))
	printResults(grid, results, 5)
}

func findPath(startPoint Point, endPoint Point, grid [][]int) []State {
	offsets := []struct {
		x, y int
	}{
		{-1, 0},
		{0, -1},
		{1, 0},
		{0, 1},
	}

	var results []State

	currPoint := startPoint

	//lack of queue :(
	toCheck := []State{{point: currPoint, stepNum: 1, checked: make(map[Point]int)}}
	for {
		if len(toCheck) == 0 {
			break
		}

		//nice gotcha here, we can't simply use :=, otherwise we shadow `toCheck` variable
		state := toCheck[0]
		toCheck = toCheck[1:]
		if state.checked[state.point] > 0 {
			continue
		}

		state.checked[state.point] = state.stepNum

		if state.point == endPoint {
			results = append(results, state)
			continue
		}

		for _, offset := range offsets {
			targetPoint := Point{state.point.x + offset.x, state.point.y + offset.y}
			if isPassable(grid, targetPoint) {
				checked := copyMap(state.checked)
				toCheck = append(toCheck, State{
					point:   targetPoint,
					stepNum: state.stepNum + 1,
					checked: checked,
				})
			}
		}
	}
	return results
}

func getStartPoint(grid [][]int) Point {
	return Point{0, 0}
}

func getEndPoint(grid [][]int) Point {
	return Point{len(grid[0]) - 1, len(grid) - 1}
}

func isCorrect(p Point, topX, topY int) bool {
	return p.x >= 0 && p.x <= topX && p.y >= 0 && p.y <= topY
}

func isPassable(grid [][]int, p Point) bool {
	return isCorrect(p, len(grid[0])-1, len(grid)-1) && grid[p.y][p.x] == 0
}

func copyMap(original map[Point]int) map[Point]int {
	result := make(map[Point]int)

	for k, v := range original {
		result[k] = v
	}

	return result
}

// extra functions

func printResults(grid [][]int, results []State, topSize int) {
	topX := len(grid[0]) - 1
	topY := len(grid) - 1

	for _, state := range getTop(results, topSize) {
		for y := 0; y <= topY; y++ {
			for x := 0; x <= topX; x++ {
				value := state.checked[Point{x, y}]
				if value > 0 {
					valueToShow := value % 10
					if valueToShow == 0 {
						print("#")
					} else {
						print(valueToShow)
					}
				} else {
					print(value)
				}
			}

			print("\n")
		}

		print("\n")
	}
}

func getTop(results []State, topCount int) []State {
	sorted := SortByPathLength(results)
	sort.Sort(sorted)

	return sorted[:topCount]
}

type SortByPathLength []State

func (s SortByPathLength) Len() int {
	return len(s)
}

func (s SortByPathLength) Less(i, j int) bool {
	return getPathLen(s[i]) < getPathLen(s[j])
}

func (s SortByPathLength) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func getPathLen(state State) int {
	result := 0

	for _, stepNum := range state.checked {
		if stepNum > 0 {
			result++
		}
	}

	return result
}
