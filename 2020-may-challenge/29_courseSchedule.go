package main

import (
	"fmt"
	"reflect"
)

func main() {
	assert(canFinish(2, [][]int{{1, 0}}), true)
	assert(canFinish(2, [][]int{{1, 0}, {0, 1}}), false)
	assert(canFinish(1, [][]int{}), true)
	assert(canFinish(3, [][]int{{0, 1}, {0, 2}, {1, 2}}), true)
	assert(canFinish(3, [][]int{{0, 1}}), true)
}

func assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

type Course struct {
	courseId      int
	prerequisites []*Course
	permanentMark bool
	temporaryMark bool
}

func canFinish(numCourses int, prerequisites [][]int) bool {
	if len(prerequisites) == 0 {
		return true
	}

	courses := make(map[int]*Course, numCourses)
	for _, prerequisite := range prerequisites {
		preCourse := get(courses, prerequisite[1])
		course := get(courses, prerequisite[0])

		course.prerequisites = append(course.prerequisites, preCourse)
	}

	for _, course := range courses {
		if !course.permanentMark {
			noCycle := visit(course)
			if !noCycle {
				return false
			}
		}
	}

	return true
}

func visit(course *Course) bool {
	if course.permanentMark {
		return true
	}

	if course.temporaryMark {
		return false
	}

	course.temporaryMark = true

	for _, prerequisite := range course.prerequisites {
		noCycle := visit(prerequisite)
		if !noCycle {
			return false
		}
	}

	course.temporaryMark = false
	course.permanentMark = true

	return true
}

func get(courses map[int]*Course, courseId int) *Course {
	if course, ok := courses[courseId]; ok {
		return course
	} else {
		course := &Course{courseId: courseId}
		courses[courseId] = course
		return course
	}
}
