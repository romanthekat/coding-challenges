package common

import (
	"fmt"
	"reflect"
)

func Assert(got, want interface{}) {
	fmt.Printf("%v|got: %v, want: %v\n", reflect.DeepEqual(got, want), got, want)
}
