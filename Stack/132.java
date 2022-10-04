class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int th = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < th)
                return true;
            while (!st.isEmpty() && st.peek() < nums[i]) {
                th = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third)
                return true;
            while (top < n && nums[i] > nums[top])
                third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }
}

// https://leetcode.com/problems/132-pattern/