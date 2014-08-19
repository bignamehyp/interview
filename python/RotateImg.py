class RotateImg:
    def rotate(self, matrix):
        l = 0
        r = len(matrix) - 1
        while l < r:
            for y in range(l, r):
                tmp = matrix[l][y]
                matrix[l][y] = matrix[r-y+l][l]
                matrix[r-y+l][l] = matrix[r][r-y+l]
                matrix[r][r-y+l] = matrix[y][r]
                matrix[y][r] = tmp
            l += 1
            r -= 1
        return matrix
        