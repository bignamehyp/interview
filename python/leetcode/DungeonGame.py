class Solution:
    # @param dungeon, a list of lists of integers
    # @return a integer
    def calculateMinimumHP(self, dungeon):
        m = len(dungeon)
        if m == 0:
            return 0
        n = len(dungeon[0])
        minHP = [[ 1 for j in range(n)] for i in range(m)]
        minHP[m-1][n-1] = 1
        if dungeon[m-1][n-1] < 0:
            minHP[m-1][n-1] -= dungeon[m-1][n-1]
        for j in range(n-2, -1, -1):
            minHP[m-1][j] = max(minHP[m-1][j+1] - dungeon[m-1][j], 1)
        for i in range(m-2, -1, -1):
            minHP[i][n-1] = max(minHP[i+1][n-1] - dungeon[i][n-1], 1)
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                minHP[i][j] = max(min(minHP[i+1][j], minHP[i][j+1]) - dungeon[i][j], 1)
        return minHP[0][0]
            