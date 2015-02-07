class Pascal:
    def generate(self, numRows):
        solns = []
        for n in range(1, numRows+1):
            solns.append(self.getRow(n))
        return solns
        
    def getRow(self, n):
        soln = [1 for i in range(n)]
        for i in range(1, n-1):
            soln[i] = soln[i-1] * (n - i) / i
        return soln