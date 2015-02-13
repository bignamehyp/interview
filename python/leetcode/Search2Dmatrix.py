class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        l = 0
        r = m - 1
        while l <= r:
            mid = (l + r) / 2
            if matrix[mid][n-1] == target:
                return True
            elif matrix[mid][n-1] > target:
                r = mid - 1
            else:
                l = mid + 1
        if l == m:
            return False
        col = l
        l = 0
        r = n - 1
        while l <= r:
            mid = (l + r) / 2
            if matrix[col][mid] == target:
                return True
            elif matrix[col][mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return False