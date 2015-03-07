class Solution:
    # @param m: An integer m denotes the size of a backpack
    # @param A & V: Given n items with size A[i] and value V[i]
    # @return: The maximum value
    def backPackII(self, m, A, V):
        # write your code here
        dp = [0 for t in range(m+1)]
        for i in range(len(A)):
            copy = dp[:]
            for target in range(1, m+1):
                if target >= A[i]:
                    dp[target] = max(copy[target], copy[target-A[i]] + V[i])
        return dp[m]