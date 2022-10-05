class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int b[] = new int[temperatures.length];
        Stack st = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (!st.isEmpty())
                b[i] = st.peek() - i;
            else
                b[i] = 0;
            st.push(i);
        }
        return b;
    }
}

// https://leetcode.com/problems/daily-temperatures/