class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        r = 0
        st = set()
        longest = 0

        while (l <= r and r < len(s)):
            if s[r] not in st:
                st.add(s[r])
                longest = max(longest, r - l + 1)
                r += 1
            else:
                while (s[r] in st):
                    st.remove(s[l])
                    l += 1
        return longest

# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/