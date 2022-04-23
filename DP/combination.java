class Solution {
    public static int comb(int n, int r, int[][] dp) {
        if (r > n) {
            dp[n][r] = 0;
            return 0;
        }
        if (n == r || r == 0) {
            dp[n][r] = 1;
            return 1;
        }
        dp[n][r] = comb(n - 1, r - 1, dp) + comb(n - 1, r, dp);
        return dp[n][r];
    }

    public static int comb(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (i == j || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][r];
    }
}