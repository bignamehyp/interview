class Solution:
    # @return an integer
    def numDistinct(self, S, T):
        if len(S) == 0 or len(T) == 0:
            return 0
        
        dp = [ [0 for t in range(len(T))] for s in range(len(S))]
        
        
        for t in range(len(T)):
            for s in range(t, len(S)):
                if s != t:
                    dp[s][t] = dp[s-1][t]
                if S[s] == T[t]:
                    if t >0 and s > 0:
                        dp[s][t] += dp[s-1][t-1]
                    else:
                        dp[s][t] += 1
        return dp[len(S)-1][len(T)-1
