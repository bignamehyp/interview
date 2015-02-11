class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        ans = 0
        div = 5
        while div <= n:
            ans += (n / div)
            div *= 5
        return ans