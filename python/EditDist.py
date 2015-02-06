class Solution:
    # @return an integer
    def minDistance(self, word1, word2):
        dp = [ [0 for j in range(len(word2) + 1)] for i in range(len(word1)+1)]
        for j in range(len(word2)):
            dp[0][j+1] = j + 1
        for i in range(len(word1)):
            dp[i+1][0] = i + 1
        
        for i in range(0, len(word1)):
            for j in range(0, len(word2)):
                if word1[i] == word2[j]:
                    dp[i+1][j+1] = dp[i][j]
                else:
                    dp[i+1][j+1] = min(dp[i][j+1], min(dp[i+1][j], dp[i][j])) + 1
        return dp[len(word1)][len(word2)]
