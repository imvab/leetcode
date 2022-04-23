class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        HashSet<Character> hs = new HashSet<Character>();
        int maxLen = 0;
        int start = 0;
        int end = 0;

        while (start < s.length() && end < s.length()) {
            if (hs.contains(s.charAt(end))) {
                while (hs.contains(s.charAt(end))) {
                    hs.remove(s.charAt(start));
                    start++;
                }
            } else {
                hs.add(s.charAt(end));
                end++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/