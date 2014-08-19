class SetMatrixZeros:
    def setZeroes(self, matrix):
        NX = len(matrix)
        NY = len(matrix[0])
        firstRow = False
        firstCol = False
        for y in range(NY):
            if matrix[0][y] == 0:
                firstRow = True
        for x in range(NX):
            if matrix[x][0] == 0:
                firstCol = True
        
        for x in range(1, NX):
            for y in range(1, NY):
                if matrix[x][y] == 0:
                    matrix[x][0] = 0
                    matrix[0][y] = 0

        for x in range(1,NX):
            for y in range(1,NY):
                if matrix[x][0] == 0 or matrix[0][y] == 0:
                    matrix[x][y] = 0
        if firstRow:
            for y in range(NY):matrix[0][y] = 0
        if firstCol:            
            for x in range(NX):matrix[x][0] = 0
