class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1; // flowers req > flowers available

        int l = 1;
        int r = (int) 1e9; // int value of 10^9

        while (l < r) {
            int mid = (l + r) / 2;

            int bouquets = 0;
            int flowers = 0; // adjacebnt flowers found

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] > mid) { // this flower has not bloomed
                    flowers = 0;
                } else {
                    flowers++;

                    if (flowers == k) { // i can make 1 bouquet
                        bouquets++;
                        flowers = 0;
                    }
                }
            }

            if (bouquets < m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/