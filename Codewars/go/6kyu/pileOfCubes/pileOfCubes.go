package kata

const INITIAL_STEP_SIZE = 8192

//FindNb calculates pile of cubes height by total amount using adapted bisection method
func FindNb(m int) int {
	currentStepSize := INITIAL_STEP_SIZE

	height := 1

	for {
		testVolume := calculateVolume(height)

		if testVolume < m {
			height += currentStepSize
		} else if testVolume > m {
			if currentStepSize == 1 {
				return -1
			}

			currentStepSize /= 2

			height -= currentStepSize
		} else if testVolume == m {
			return height
		}
	}
}

func calculateVolume(height int) int {
	volume := 0

	for i := 1; i <= height; i++ {
		volume = volume + i*i*i
	}

	return volume
}
