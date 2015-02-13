class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def exist(self, board, word):
        m = len(board)
        if m == 0:
            return len(word) == 0
        n = len(board[0])
        if len(word) == 0:
            return True
        if len(word) > m * n:
            return False
        
        visited = [[False for a in range(n)] for b in range(m)]
        for j in range(n):
            for i in range(m):
                if board[i][j] == word[0] and self.dfs(i, j, board, word[1:], visited):
                    return True
        return False
        
    def dfs(self, x, y, board, word, visited):
        if word == '':
            return True
        m = len(board)
        n = len(board[0])
        visited[x][y] = True
        if x > 0 and board[x-1][y] == word[0] and not visited[x-1][y] and self.dfs(x-1, y, board, word[1:], visited):
            return True
        if x + 1 < m and board[x+1][y] == word[0] and not visited[x+1][y] and self.dfs(x+1, y, board, word[1:], visited):
            return True
        if y > 0 and board[x][y-1] == word[0] and not visited[x][y-1] and self.dfs(x, y-1, board, word[1:], visited):
            return True
        if y + 1 < n and board[x][y+1] == word[0] and not visited[x][y+1] and self.dfs(x, y+1, board, word[1:], visited):
            return True
        visited[x][y] = False
        return False
