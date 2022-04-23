class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            int h = height[i];

            while (!st.isEmpty() && h > height[st.peek()]) {
                int index = st.pop(); // index at top of stack

                if (!st.isEmpty()) {
                    volume += (Math.min(h, height[st.peek()]) - height[index]) * (i - st.peek() - 1);
                }
            }
            st.push(i);
        }
        return volume;
    }
}

// https://leetcode.com/problems/trapping-rain-water/