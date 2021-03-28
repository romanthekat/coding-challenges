import Common.Companion.assertEquals

/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Constraints:

    1 <= s.length <= 2 * 10^5
    s consists only of printable ASCII characters.
*/
class `125_validPalindrome` {
    class Solution {
        fun isPalindrome(s: String): Boolean {
            var leftIndex = 0
            var rightIndex = s.length - 1

            while (leftIndex <= rightIndex) {
                val left = s[leftIndex]
                val right = s[rightIndex]

                if (!left.isLetterOrDigit()) {
                    leftIndex++
                } else if (!right.isLetterOrDigit()) {
                    rightIndex--
                } else {
                    if (left.toLowerCase() != right.toLowerCase()) {
                        return false
                    }

                    leftIndex++
                    rightIndex--
                }
            }
            return true
        }
    }
}

fun main() {
    val s = `125_validPalindrome`.Solution()
    assertEquals(s.isPalindrome("A man, a plan, a canal: Panama"), true)
    assertEquals(s.isPalindrome("race a car"), false)
    assertEquals(s.isPalindrome("abcacba"), true)
    assertEquals(s.isPalindrome("abccba"), true)
    assertEquals(s.isPalindrome("abcdba"), false)
    assertEquals(s.isPalindrome(""), true)
}