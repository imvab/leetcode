class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        // Compute rightSum which is essentially the total sum at this stage
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            // With each iteration substract the current element from the already computed
            // rightSum
            rightSum = rightSum - nums[i];
            // Compare rightSum and leftSum before updating the leftSum so that rightSum is
            // compared to the leftSum from previous iteration
            if (rightSum == leftSum) {
                return i;
            }
            // Update leftSum
            leftSum += nums[i];
        }
        return -1;
    }
}

// https://leetcode.com/problems/find-pivot-index/