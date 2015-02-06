class SpiralMatrixII:
    def generateMatrix(self, n):
        l = 0
        r = n - 1
        val = 1
        a = [ [0 for i in range(n)] for j in range(n) ]
        while l  < r:
            for y in range(l,r+1):
                a[l][y] = val
                val += 1
            for x in range(l+1, r):
                a[x][r] = val
                val += 1
            for y in range(r, l-1, -1):
                a[r][y] = val
                val += 1
            for x in range(r-1, l, -1):
                a[x][l] = val
                val += 1
            l++
            r--
        if l == r:
            a[l][l] = val
            val += 1
        return a
        
            