class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        res = 0
        chars = {}
        left = 0

        for right in range(n):
            if (s[right] not in chars or chars[s[right]] < left):
                chars[s[right]] = right
                res = max(res, right - left + 1)
            else:
                left = chars[s[right]] + 1
                chars[s[right]] = right
        return res

# https://leetcode.com/problems/longest-substring-without-repeating-characters/