package kata

import (
	"testing"
	"strings"
	"fmt"
)

//TestToNato tests transformation from some text to pilot's alphabet
func TestToNato(t *testing.T) {
	correctResult := "India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta !"
	simpleCase := ToNato("If you can read !")

	if !strings.EqualFold(simpleCase, correctResult) {
		t.Error(fmt.Printf("Transformed wrong, expected '%s',\n but got '%s'", correctResult, simpleCase))
	}
}
