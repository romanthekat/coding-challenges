package common

import (
	"fmt"
	"reflect"
)

func AssertEqual(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}

func Max[N int | float64](i, j N) N {
	if i > j {
		return i
	} else {
		return j
	}
}

func Min[N int | float64](i, j N) N {
	if i < j {
		return i
	} else {
		return j
	}
}
