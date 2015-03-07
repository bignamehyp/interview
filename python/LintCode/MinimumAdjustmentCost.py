class Solution:
    # @param A: An integer array.
    # @param target: An integer.
    def MinAdjustmentCost(self, A, target):
        # write your code here
        S = 100
        dp = [[float('inf') for i in range(S+1)] for j in range(len(A)+1)]
        
        for i in range(S + 1):
            dp[0][i] = 0
        
        for i in range(1, len(A) + 1):
            for j in range(1, S+1):
                for k in range(max(1, j - target), min(S, j + target) + 1):
                    dp[i][j] = min(dp[i][j], dp[i-1][k] + abs(A[i-1] - j))
        
        minA = float('inf')
        for j in range(1, S+1):
            minA = min(minA, dp[len(A)][j])
        return minA
