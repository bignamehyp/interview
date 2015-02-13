class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
        m = len(matrix)
        if m == 0:
            return 0
        n = len(matrix[0])
        rows = [0 for i in range(n+1)]
        maxArea = 0
        for i in range(m):
            for j in range(n):
                if int(matrix[i][j]) == 1:
                    rows[j] += 1
                else:
                    rows[j] = 0
            stack = []
            k = 0
            while k < n + 1:
                if not stack or rows[k] > rows[stack[-1]]:
                    stack.append(k)
                    k += 1
                else:
                    h = rows[stack.pop()]
                    l = stack[-1] if stack else -1
                    area = h * (k - l - 1)
                    if area > maxArea:
                        maxArea = area
        return maxArea