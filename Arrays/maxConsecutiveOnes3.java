class Solution {
    public int longestOnes(int[] nums, int k) {
        int x = 0;
        int zeroes = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroes++;

            while (zeroes > k) {
                if (nums[x] == 0)
                    zeroes--;
                x++;
            }

            ones = Math.max(ones, i - x + 1);
        }

        return ones;
    }
}

// https://leetcode.com/problems/max-consecutive-ones-iii/