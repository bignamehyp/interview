class UniqueBinaryTrees:
    def numTrees(self, n):
        dp = [1 for i in range(n+1)]
        for i in range(1, n+1):
            dp[i] = 0
            for top in range(1, i+1):
                dp[i] += dp[top - 1] * dp[i - top]
        return dp[n]