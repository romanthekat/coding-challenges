import Common.Companion.assertEquals
import java.util.Collections.min
import kotlin.math.abs
import kotlin.math.min

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

Example 3:

Input: height = [4,3,2,1,4]
Output: 16

Example 4:

Input: height = [1,2,1]
Output: 2

Constraints:

    n == height.length
    2 <= n <= 10^5
    0 <= height[i] <= 10^4
 */
//TODO rely on either dynamic programming and square matrix or two pointers (left/right)
class `11_containerWithMostWater` {
    class Solution {
        fun maxArea(height: IntArray): Int {
            var topVolume = 0

            for (idx1 in height.indices) {
                for (idx2 in idx1 + 1 until height.size) {
                    val volume = min(height[idx1], height[idx2]) * abs((idx1 - idx2))
                    if (volume > topVolume) {
                        topVolume = volume
                    }
                }
            }

            return topVolume
        }
    }
}

fun main() {
    val s = `11_containerWithMostWater`.Solution()
    assertEquals(s.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)), 49)
    assertEquals(s.maxArea(intArrayOf(1, 1)), 1)
    assertEquals(s.maxArea(intArrayOf(4, 3, 2, 1, 4)), 16)
    assertEquals(s.maxArea(intArrayOf(1, 2, 1)), 2)
}