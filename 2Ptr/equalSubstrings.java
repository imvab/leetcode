class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];

        for (int i = 0; i < n; i++)
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));

        int maxLen = 0; // return value
        int start = 0;
        int cost = 0; // cost consumed so far

        for (int end = 0; end < n; end++) {
            cost += diff[end];

            while (cost > maxCost) {
                cost -= diff[start];
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}

// https://leetcode.com/problems/get-equal-substrings-within-budget/