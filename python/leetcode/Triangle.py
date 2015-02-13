class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if len(triangle) == 0:
            return 0
        for l in range(len(triangle) - 2, -1, -1):
            for i in range(l + 1):
                triangle[l][i] += min(triangle[l+1][i], triangle[l+1][i+1])
        return triangle[0][0]