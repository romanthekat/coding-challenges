# Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string], where the
# encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a
# positive integer. You may assume that the input string is always valid; No extra white spaces, square brackets are
# well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits
# are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
#
# class Solution:
#    def decodeString(self, s: str) -> str:
#
# Input: s = "3[a]2[bc]"
# Output: "aaabcbc"
#
# Input: s = "3[a2[c]]"
# Output: "accaccacc"
#
# Input: s = "2[abc]3[cd]ef"
# Output: "abcabccdcdcdef"
#
# Input: s = "abc3[cd]xyz"
# Output: "abccdcdcdxyz"
#
# Input: s = "100[leetcode]"
# Output: "leetcodeleetcodeleetcodeleetcodeleetcodeleetcode...."


# iterate, left-right
# ?finite state machine
# as is, numbers, gather to repeat


# Input: s = "abc34[cd]xyz"
# Input: s = "q34[abc210[ac]]"
# stack for commands
# keep ?numbers
#   triggered by a number
# iterate until [ symbol, , put number on stack
# iterate further, recursive continue
# until ] ->
#   till some stop symbol in stack? [
# TODO fully solve https://leetcode.com/problems/decode-string/solution/
class Solution:
    def decodeString(self, s: str) -> str:
        result = ""

        stack = []

        digit = ""
        symbols = ""

        for c in s:
            if c.isdigit():
                digit += c
            elif c == '[':
                stack.append(digit)
                digit = ""
                stack.append(symbols)
                symbols = ""
            elif c == ']':
                symbols = stack.pop()
                digits = stack.pop()
                result += int(digits) * symbols

        return result


s = Solution()

print(s.decodeString("3[a]2[bc]"))
print("CORRECT: aaabcbc")

print(s.decodeString("3[a2[c]]"))
print("CORRECT: accaccacc")

print(s.decodeString("2[abc]3[cd]ef"))
print("CORRECT: abcabccdcdcdef")

Input: s = "abc3[cd]xyz"
print("CORRECT: abccdcdcdxyz")
