class NQueensII:
    def totalNQueens(self, n):
        self.res = 0
        self.solve(n, 0, [-1 for i in xrange(n)])
        return self.res
     
    def solve(self, n, currQueenNum, board):
        if currQueenNum == n: self.res += 1; return
        # try to put a Queen in (currQueenNum, 0), (currQueenNum, 1), ..., (currQueenNum, n-1)
        for i in xrange(n):
            valid = True  # test whether board[currQueenNum] can be i or not
            for k in xrange(currQueenNum):
                # check column
                if board[k] == i: valid = False; break
                # check diagonal
                if abs(board[k] - i) == currQueenNum - k: valid = False; break
            if valid:
                board[currQueenNum] = i
                self.solve(n, currQueenNum + 1, board)
    

    
    
