class Pascal:
   
    def getRow(self, rowIndex):
        soln = [1 for i in range(rowIndex + 1)]
        for i in range(1, rowIndex/2+1):
            soln[i] = soln[i-1] * (rowIndex + 1 - i) / i
            soln[rowIndex - i] = soln[i]
        return soln