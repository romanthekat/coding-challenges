package main

import (
	"github.com/romanthekat/coding-challenges/LeetCode/common"
	"math/bits"
)

func reverseBits(num uint32) uint32 {
	return bits.Reverse32(num)
}

func main() {
	common.AssertEqual(reverseBits(43261596), 964176192)
	common.AssertEqual(reverseBits(4294967293), 3221225471)
}
