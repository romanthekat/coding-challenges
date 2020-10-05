package kata

type inputValues struct {
	maxTotalDistance int
	townsCount       int
	distances        []int
}

type Choices struct {
	totalDistances []int
}

func comb(n, m int, emit func([]int)) {
	s := make([]int, m)
	last := m - 1
	var rc func(int, int)
	rc = func(i, next int) {
		for j := next; j < n; j++ {
			s[i] = j
			if i == last {
				emit(s)
			} else {
				rc(i+1, j+1)
			}
		}
		return
	}
	rc(0, 0)
}

func (choices *Choices) addChoice(totalDistance int) {
	choices.totalDistances = append(choices.totalDistances, totalDistance)
}

func ChooseBestSum(maxTotalDistance, townsCount int, distances []int) int {
	input := inputValues{maxTotalDistance, townsCount, distances}

	choices := chooseBestSum(input, &Choices{[]int{}})

	return analyzeChoices(choices)
}

func analyzeChoices(choices *Choices) int {
	return getMax(choices)
}

func getMax(choices *Choices) int {
	max := -1

	for _, totalDistance := range choices.totalDistances {
		if totalDistance > max {
			max = totalDistance
		}
	}

	return max
}

func chooseBestSum(input inputValues, choices *Choices) *Choices {
	comb(len(input.distances), input.townsCount, func(c []int) {
		totalDistance := totalDistance(input, c)

		if totalDistance <= input.maxTotalDistance {
			choices.addChoice(totalDistance)
		}
	})

	return choices
}

func totalDistance(input inputValues, choice []int) int {
	totalDistance := 0

	for _, distanceNumber := range choice {
		totalDistance += input.distances[distanceNumber]
	}

	return totalDistance
}
