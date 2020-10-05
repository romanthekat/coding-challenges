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
		versionToCheck := (lowVersion + highVersion) / 2 //low + (high-low) / 2

		if isBadVersion(versionToCheck) {
			highVersion = versionToCheck
		} else {
			lowVersion = versionToCheck + 1
		}
	}

	return lowVersion
}

func isBadVersion(version int) bool {
	return version >= 3
}
