class SurroundedRegions:
        def solve(self, board):
        cols = len(board)
        if cols == 0:
            return
        rows = len(board[0])
        queue = collections.deque()

        for i in range(cols):
            if board[i][0] == 'O':
                queue.append((i,0))
            if board[i][rows-1] == 'O':
                queue.append((i,rows-1))
        for j in range(rows):
            if board[0][j] == 'O':
                queue.append((0,j))
            if board[cols-1][j] == 'O':
                queue.append((cols-1,j))
        
        while len(queue) > 0:
            (i, j) = queue.popleft()
            if board[i][j] != 'O':
                continue
            board[i][j] = 'M'
            if i > 0 and board[i-1][j] == 'O':
                queue.append((i-1,j))
            if i + 1 < cols and board[i+1][j] == 'O':
                queue.append((i+1,j))
            if j > 0 and board[i][j-1] == 'O':
                queue.append((i,j-1))
            if j + 1 < rows and board[i][j+1] == 'O':
                queue.append((i,j+1))
                
        for i in range(cols):
            for j in range(rows):
                if board[i][j] == 'M':
                    board[i][j] = 'O'
                else:
                    board[i][j] = 'X'