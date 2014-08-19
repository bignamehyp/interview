class SudokuSolver:
    def solveSudoku(self, board):
        rows = [ [True for i in range(9)] for j in range(9)]
        cols = [ [True for i in range(9)] for j in range(9)]
        sqrs = [ [True for i in range(9)] for j in range(9)]
        digits = {'1':0,'2':1,'3':2,'4':3,'5':4,'6':5,'7':6,'8':7,'9':8}
        
        for i in range(9):
            for j in range(9):
                s = (i / 3) * 3 + j / 3
                if board[i][j] in digits:
                    d = digits[board[i][j]]
                    cols[i][d] = False
                    rows[j][d] = False
                    sqrs[s][d] = False                   
        self.solve(board, rows, cols, sqrs, 0, 0)

    def solve(self, board, rows, cols, sqrs,i,j):
        if i == 9:
            return True
        if j == 8:
            j2 = 0
            i2 = i + 1
        else:
            j2 = j + 1
            i2 = i
        if board[i][j] != '.':
            return self.solve(board, rows, cols, sqrs, i2,j2)

        s = (i / 3) * 3 + j / 3
        for d in range(9):
            if cols[i][d] and rows[j][d] and sqrs[s][d]:
                board[i][j] = str(d + 1)
                cols[i][d] = False
                rows[j][d] = False
                sqrs[s][d] = False 
                if self.solve(board, rows, cols, sqrs, i2,j2):
                    return True
                board[i][j] = '.'
                cols[i][d] = True
                rows[j][d] = True
                sqrs[s][d] = True 
        return False