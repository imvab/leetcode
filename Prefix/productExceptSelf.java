class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;

        for (int i = 0; i < n; i++) { // prefix product
            product *= nums[i];
            ans[i] = product;
        }

        product = 1;
        for (int i = n - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * product;
            product *= nums[i];
        }

        ans[0] = product;
        return ans;
    }
}

// https://leetcode.com/problems/product-of-array-except-self/