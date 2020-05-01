package main

import "fmt"

func main() {
	fmt.Println(firstBadVersion(5))
}

/**
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */
func firstBadVersion(n int) int {
	lowVersion := 1
	highVersion := n

	for lowVersion < highVersion {
		if (highVersion - lowVersion) <= 1 {
			if isBadVersion(lowVersion) {
				return lowVersion
			} else {
				return highVersion
			}
		}

		versionToCheck := (lowVersion + highVersion) / 2

		if isBadVersion(versionToCheck) {
			highVersion = versionToCheck
		} else {
			lowVersion = versionToCheck
		}
	}
}

func isBadVersion(version int) bool {
	return version >= 4
}
