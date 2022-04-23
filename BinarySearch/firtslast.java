class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    public int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;

            if (nums[mid] == target)
                res = mid;
        }
        return res;
    }

    public int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;

            if (nums[mid] == target)
                res = mid;
        }
        return res;
    }
}

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/