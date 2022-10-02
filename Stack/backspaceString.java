class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stackS.isEmpty() && ch == '#') {
                stackS.pop();
            }

            else if (ch != '#') {
                stackS.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (!stackT.isEmpty() && ch == '#') {
                stackT.pop();
            }

            else if (ch != '#') {
                stackT.push(ch);
            }
        }

        if (stackS.equals(stackT)) {
            return true;
        }

        return false;
    }
}

// https://leetcode.com/problems/backspace-string-compare/