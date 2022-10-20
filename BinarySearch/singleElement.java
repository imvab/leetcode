class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid + 1]) // here is the condition for checking is mid on its right place or not
                mid = mid - 1;
            if ((mid - start + 1) % 2 == 0) // check length of left if even the move to right side, in this we have
                                            // added +1
                // because we are including mid in left side, it is not possible to include it
                // on both the sides
                start = mid + 1;
            else // here if length of left side is odd then then answer will be on that side
                end = mid;
        }
        // in the end start,end and mid will be on same position then loop will break
        return nums[start];
    }
}

// https://leetcode.com/problems/single-element-in-a-sorted-array/