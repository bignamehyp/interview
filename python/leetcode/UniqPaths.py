class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        k = m + n - 2
        l = min(m, n) - 1
        ans = 1
        for i in range(l):
            ans =  ans * (k - i) / (i + 1)
        return ans