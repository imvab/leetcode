class Solution {
    public boolean find132pattern(int[] nums) {
        int x = Integer.MIN_VALUE;
        int largest_num = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            largest_num = nums[i];
            if (nums[i] < x)
                return true;
            while (!s.isEmpty() && nums[i] > s.peek()) {
                x = s.peek();
                largest_num = Math.max(largest_num, s.peek());
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}

// https://leetcode.com/problems/132-pattern/