import Common.Companion.assertEquals

class `300_longestIncreasingSubsequence` {
    class Solution {
        fun lengthOfLIS(nums: IntArray): Int {
            return 0
         }
    }
}

fun main() {
    val s = `300_longestIncreasingSubsequence`.Solution()
    assertEquals(s.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)), 4)
    assertEquals(s.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)), 4)
    assertEquals(s.lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)), 1)
}