class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 1

        coins.reverse()
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                dp[i][j] = dp[i - 1][j]
                if (j - coins[i - 1] >= 0):
                    dp[i][j] += dp[i][j - coins[i - 1]]

        return dp[len(coins)][amount]
        