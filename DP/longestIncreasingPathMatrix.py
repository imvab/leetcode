class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        dp = {}
        ROW, COL = len(matrix), len(matrix[0])

        def dfs(r, c, prev):
            if (r < 0 or c < 0 or r == ROW or c == COL or matrix[r][c] <= prev):
                return 0
            if (r, c) in dp:
                return dp[(r, c)]

            res = 1
            res = max(res, 1 + dfs(r + 1, c, matrix[r][c]))
            res = max(res, 1 + dfs(r - 1, c, matrix[r][c]))
            res = max(res, 1 + dfs(r, c + 1, matrix[r][c]))
            res = max(res, 1 + dfs(r, c - 1, matrix[r][c]))

            dp[(r, c)] = res
            return res

        max_val = 0
        for i in range(ROW):
            for j in range(COL):
                max_val = max(max_val, dfs(i, j, -1))
        return max_val
        