class PalindromePartitionII:
    def minCut(self, S):
        isPalin = [ [False for i in range(len(S)) ] for j in range(len(S))  ]
        dp = [ i for i in range(len(S)) ]
        for i in range(len(S)): isPalin[i][i] = True
        
        for i in range(1,len(S)):
            for j in range(i+1):
                if S[i] == S[j] and ( i - j < 2 or isPalin[j+1][i-1] ):
                    isPalin[j][i] = True
                    if j == 0:
                        dp[i] = 0
                        break
                    else:
                        dp[i] = min(dp[i], 1 + dp[j-1])
        return dp[len(S) - 1]
        
    