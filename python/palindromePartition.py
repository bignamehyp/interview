class PalindromePartition:
    def partition(self, s):
        isPal = [ [False for i in range(len(s))] for j in range(len(s)) ]
        for i in range(len(s)):
            isPal[i][i] = True
        for end in range(1, len(s)):
            for start in range(0, end+1):
                if s[start] == s[end] and ( end -start < 2 or isPal[start + 1][end - 1] ):
                    isPal[start][end] = True

        solns = []
        soln = []
        self.dfs(solns, soln, isPal, 0, s)
        return solns
        
    def dfs(self, solns, soln, isPal, pos, s):
        if pos == len(s):
            solns.append( soln[:] )
        for i in range(pos, len(s)):
            if isPal[pos][i]:
                soln.append( s[pos:i+1] )
                self.dfs(solns, soln, isPal, i+1, s)
                soln.pop()
        
                