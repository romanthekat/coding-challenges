package kata

import (
	"unicode"
	"strings"
)

func ToNato(words string) string {
	nato := []string{"Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot","Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"}

	var result []string

	for _, letter := range words {
		if unicode.IsSpace(letter) {
			continue
		}

		wordForLetter := getWordForLetter(unicode.ToUpper(letter), nato)
		result = append(result, wordForLetter)
	}

	return strings.Join(result, " ")
}

func getWordForLetter(letter rune, dictionary []string) string {
	for _, dictionaryWord := range dictionary {
		if getFirstRune(dictionaryWord) == letter {
			return dictionaryWord
		}
	}

	//log.Fatal("It's impossible to find word in dictionary for letter " + string(letter))
	return string(letter)
}

func getFirstRune(str string) rune {
	for _, letter := range str {
		return letter
	}
	return rune(' ')
}