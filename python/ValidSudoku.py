class ValidSudoku:
    def isValidSudoku(self, board):
        rows = [ [True for i in range(9)] for j in range(9)]
        cols = [ [True for i in range(9)] for j in range(9)]
        sqrs = [ [True for i in range(9)] for j in range(9)]
        digits = {'1':0,'2':1,'3':2,'4':3,'5':4,'6':5,'7':6,'8':7,'9':8}
        for i in range(9):
            for j in range(9):
                s = (i / 3) * 3 + j / 3
                if board[i][j] in digits:
                    d = digits[board[i][j]]
                    if rows[j][d]:
                        rows[j][d] = False
                    else:
                        return False
                    if cols[i][d]:
                        cols[i][d] = False
                    else:
                        return False
                    if sqrs[s][d]:
                        sqrs[s][d] = False
                    else:
                        return False
        return True
                    