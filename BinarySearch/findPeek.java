class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // we are in dec part of the array
                end = mid;
            } else {// we are in inc part of array
                start = mid + 1;
            }
        }
        return start;
    }
}

// https://leetcode.com/problems/find-peak-element/