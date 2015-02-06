class SurroundedRegions:
    def solve(self, board):
        if len(board) == 0 or len(board[0]) == 0:
            return
        NX = len(board)
        NY = len(board[0])
        queue = collections.deque()
        visited = [ [False for j in range(NY)] for i in range(NX) ] 
        for i in range(NX):
            if board[i][0] == 'O':
                queue.append( (i,0) )
            if board[i][NY-1] == 'O':
                queue.append( (i,NY-1) )
        for j in range(1,NY-1):
            if board[0][j] == 'O':
                queue.append( (0,j) )
            if board[NX-1][j] == 'O':
                queue.append( (NX-1,j) )

        while len(queue) > 0:
            pt = queue.popleft()
            x = pt[0]
            y = pt[1]
            if board[x][y] == 'O':
                board[x][y] = '+'
            visited[x][y] = True
            if x + 1 < NX and board[x+1][y] == 'O' and visited[x+1][y] == False:
                queue.append( (x+1, y) )
            if x - 1 >= 0 and board[x-1][y] == 'O'  and visited[x-1][y] == False:
                queue.append( (x-1,y) )
            if y + 1 < NY and board[x][y+1] == 'O'  and visited[x][y+1] == False:
                queue.append( (x, y+1) )
            if y - 1 >= 0 and board[x][y-1] == 'O'  and visited[x][y-1] == False:
                queue.append( (x,y-1) )
        for i in range(NX):
            for j in range(NY):
                board[i][j] = 'O' if board[i][j] == '+' else 'X' 
