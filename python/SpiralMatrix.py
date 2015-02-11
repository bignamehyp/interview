class SpiralMatrix:
    def spiralOrder(self, matrix):
        m = len(matrix)
        if m == 0:
            return []
        n = len(matrix[0])
        il = 0
        ir = m - 1
        jl = 0
        jr = n - 1
        soln = []
        while il <= ir and jl <= jr:
            for j in range(jl, jr+1):
                soln.append(matrix[il][j])
            for i in range(il+1, ir+1):
                soln.append(matrix[i][jr])
            if ir > il:
                for j in range(jr - 1, jl -1, -1):
                    soln.append(matrix[ir][j])
            if jl < jr:
                for i in range(ir - 1, il, -1):
                    soln.append(matrix[i][jl])
            il += 1
            jl += 1
            ir -= 1
            jr -= 1
        return soln
            
                 
        
            