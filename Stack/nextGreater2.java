class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()])
                res[st.pop()] = nums[i % n];
            if (st.isEmpty())
                res[i] = -1;
            if (i < n)
                st.push(i);
        }

        return res;
    }
}

// https://leetcode.com/problems/next-greater-element-ii/