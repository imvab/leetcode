class Solution {
    public void backtrack(ArrayList<String> list, String s, int n, int left, int right) {
        if (s.length() == 2 * n) { // All the brackets are placed
            list.add(s);
            return;
        }

        if (left < n)
            backtrack(list, s + '(', n, left + 1, right);
        if (right < left)
            backtrack(list, s + ')', n, left, right + 1);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();

        backtrack(list, "", n, 0, 0);
        return list;
    }
}

// https://leetcode.com/problems/generate-parentheses/