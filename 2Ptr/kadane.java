class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], nums[i] + maxSum); // checking if sum is incresing if I add the next to the
                                                          // current or just use the next
            if (maxSoFar < maxSum) {
                maxSoFar = maxSum;
            }
        }
        return maxSoFar;
    }
}