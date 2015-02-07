class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        dp = [0 for j in range(n)]
        for i in range(m):
            dp[0] += grid[i][0]
            for j in range(1, n):
                if i == 0:
                    dp[j] = dp[j-1] + grid[0][j]
                else:
                    dp[j] = min(dp[j],dp[j-1]) + grid[i][j]
                
        return dp[n-1]
                    

                