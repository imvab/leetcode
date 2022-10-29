class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxele = Integer.MIN_VALUE, n = arr.length;
        int chunksCount = 0;
        for (int i = 0; i < n; i++) {
            maxele = Math.max(maxele, arr[i]);
            if (maxele == i)
                chunksCount++;
        }
        return chunksCount;
    }
}

// https://leetcode.com/problems/max-chunks-to-make-sorted/