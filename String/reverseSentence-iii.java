class Solution {
    public String reverseWords(String s) {
        String ans[] = s.split("\\s"), reverseWord = "";
        for (String word : ans)
            reverseWord += new StringBuilder(word).reverse().toString() + " ";
        return reverseWord.trim();
    }
}

// https://leetcode.com/problems/reverse-words-in-a-string-iii/