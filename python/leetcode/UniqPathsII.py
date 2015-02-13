class UniqPathII:
    def uniquePathsWithObstacles(self, obstacleGrid):
        NX = len(obstacleGrid)
        if NX == 0:return 1
        NY = len(obstacleGrid[0])
        dp = [[0 for y in range(NY) ] for x in range(NX)]
          
        for x in range(NX):
            for y in range(NY):
                if obstacleGrid[x][y] == 1:
                    dp[x][y] = 0
                elif x > 0 and y > 0:
                    dp[x][y] = dp[x-1][y] + dp[x][y-1]
                elif x == 0 and y > 0:
                    dp[x][y] = dp[x][y-1]
                elif y == 0 and x > 0:
                    dp[x][y] = dp[x-1][y]
                else:
                    dp[x][y] = 1
        return dp[NX-1][NY-1]
                
                    