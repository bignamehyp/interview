class GrayCode:
    def GrayCode(self, n):
        solns = []
        for i in range(1 << n):
            solns.append( i ^ i >> 1 )
        return solns