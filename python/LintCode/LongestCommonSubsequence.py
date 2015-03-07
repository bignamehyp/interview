class Solution:
    # @param A, B: Two string.
    # @return: the length of the longest common substring.
    def longestCommonSubstring(self, A, B):
        # write your code here
        maxL = 0
        dp = [ [0 for i in range(len(B) + 1)] for j in range(len(A) + 1)]
        for i in range(len(A)):
            for j in range(len(B)):
                if A[i] == B[j]:
                    dp[i+1][j+1] = dp[i][j] + 1
                    maxL = max(maxL, dp[i+1][j+1])
                else:
                    dp[i+1][j+1] = 0
        return maxL