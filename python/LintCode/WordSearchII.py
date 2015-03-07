class Solution:
    # @param board, a list of lists of 1 length string
    # @param words: A list of string
    # @return: A list of string
    def wordSearchII(self, board, words):
        # write your code here
        if len(board) == 0:
            return []
        trie = Trie()
        for word in words:
            trie.insert(word)
        soln = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                visited = set()
                self.dfs(i,j, board, visited, trie.root, soln) 
        return soln
        
    def dfs(self, i, j, board, visited, root, soln):
        if board[i][j] not in root.children or (i, j) in visited:
            return
        directions = [(0,1), (0,-1), (-1,0), (1,0)]
        node = root.children[board[i][j]]
        visited.add((i,j))
        if node.value:
            soln.append(node.value)
            node.value = None
        for dx, dy in directions:
            x1 = i + dx
            y1 = j + dy
            if x1 >= 0 and x1 < len(board) and \
            y1 >= 0 and y1 < len(board[0]) and \
            (x1,y1) not in visited: 
                self.dfs(x1,y1,board,visited,node, soln)
        visited.remove((i,j))
        
                
class TrieNode:
    def __init__(self, c):
        self.char = c
        self.children = {}
        self.value = None
class Trie:
    def __init__(self):
        self.root = TrieNode(None)
        
    def insert(self, word):
        word = word.lower()
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode(c)
            node = node.children[c]
        node.value = word
