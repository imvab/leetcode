class Solution {
    public int maxProduct(int[] nums) {
        int maxp = nums[0];
        int minp = nums[0];
        int msf = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = Math.max(nums[i], Math.max(maxp * nums[i], minp * nums[i]));
            int y = Math.min(nums[i], Math.min(maxp * nums[i], minp * nums[i]));

            maxp = x;
            minp = y;

            msf = Math.max(msf, maxp);

            System.out.println(maxp + " " + minp + " " + msf);
        }
        return msf;
    }
}

// https://leetcode.com/problems/maximum-product-subarray/