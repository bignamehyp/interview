class SpiralMatrix:
    def spiralOrder(self, matrix):
        list = []
        NX = len(matrix)
        if NX  == 0:
            return []
        NY = len(matrix[0])
        lx = 0
        rx = NX - 1
        ly = 0
        ry = NY - 1
        while lx < rx and ly < ry:
            for y in range(ly, ry + 1):
                list.append( matrix[lx][y] )
            for x in range( lx + 1, rx  ):
                list.append( matrix[x][ry] )
            for y in range( ry, ly - 1, -1 ):
                list.append( matrix[rx][y] )
            for x in range( rx - 1, lx, -1 ):
                list.append( matrix[x][ly] )
            lx += 1
            rx -= 1
            ly += 1
            ry -= 1
        if lx == rx and ly == ry:
            list.append ( matrix[lx][ly] )
        elif lx == rx and ly < ry:
            for y in range( ly, ry + 1 ):
                list.append( matrix[lx][y] )
        elif ly == ry and lx  < rx:
            for x in range(lx, rx + 1):
                list.append( matrix[x][ly] )
        return list
            
            
                 
        
            