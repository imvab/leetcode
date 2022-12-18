import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static String func(String s) {

        int l = s.length();

        int maxLength = 1;

        int index = l + 1;

        // odd length palindromic substrings // 3,5,7,9,----
        for (int middle = 0; middle < l; middle++) {
            int left = middle - 1;
            int right = middle + 1;

            while (left >= 0 && right < l && s.charAt(left) == s.charAt(right)) {
                int currentLength = (right - left + 1);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    index = left;
                } else if (currentLength == maxLength) {
                    index = Math.min(index, left);
                }
                left--;
                right++;
            }
        }

        // even length palindromic substrings
        for (int middle = 0; middle < l; middle++) // 2,4,6,8
        {
            int left = middle;
            int right = middle + 1;

            while (left >= 0 && right < l && s.charAt(left) == s.charAt(right)) {
                int currentLength = (right - left + 1);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    index = left;
                } else if (currentLength == maxLength) {
                    index = Math.min(index, left);
                }
                left--;
                right++;
            }
        }

        if (index == (l + 1)) {
            return s.substring(0, 1);
        }

        return s.substring(index, index + maxLength);
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code here
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            System.out.println(func(s));
        }
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

// https://leetcode.com/problems/longest-palindromic-substring/description/