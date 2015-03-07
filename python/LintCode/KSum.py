class Solution:
    """
    @param A: An integer array.
    @param k: a positive integer (k <= length(A))
    @param target: integer
    @return an integer
    """
    def kSum(self, A, k, target):
        # write your code here
        A.sort()
        dp = [[0 for j in range(target + 1)] for i in range(k)]
        for i in range(len(A)):
            a = A[i]
            for j in range(min(i, k-1), -1, -1):
                for t in range(target, a - 1, -1):
                    if j == 0:
                        dp[j][t] = 1 if a == t else 0
                    else:
                        dp[j][t] += dp[j-1][t-a]
        return dp[k-1][target]