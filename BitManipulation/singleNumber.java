class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            x = x ^ nums[i]; // xor of all nos of nums

        int mask = 1;
        while ((x & mask) == 0) { // moving 1 of mask to LS one in x
            mask <<= 1;
        }

        int b1 = 0;
        int b2 = 0;

        for (int i = 0; i < n; i++) {
            if ((nums[i] & mask) != 0)
                b1 = b1 ^ nums[i];
            else
                b2 = b2 ^ nums[i];
        }

        int[] result = new int[2];
        result[0] = b1;
        result[1] = b2;

        return result;
    }
}

// https://leetcode.com/problems/single-number-iii/