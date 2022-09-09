class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String ans = "";
        String[] arr = s.split(" +");
        for (int i = arr.length - 1; i >= 0; i--) {
            ans = ans + arr[i] + " ";
        }
        ans = ans.trim();
        return ans;
    }
}