class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }

        int rotatedIndex = l;

        l = 0;
        r = nums.length - 1;

        if (target >= nums[rotatedIndex] && target <= nums[r])
            l = rotatedIndex; // right side
        else
            r = rotatedIndex - 1; // left side

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/