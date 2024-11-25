class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        longest = 0

        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if (len(stack) == 0):
                    stack.append(i)
                else:
                    longest = max(longest, i - stack[-1])
        return longest

# https://leetcode.com/problems/longest-valid-parentheses/description/