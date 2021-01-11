package common

import (
	"fmt"
	"reflect"
)

func Assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func Max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
