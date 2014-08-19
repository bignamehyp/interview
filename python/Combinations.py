class Combinations:
    def combine(self, n, k):
        solns = []
        self.dfs(0,n, k, [], solns)
        return solns
        
    def dfs(self, pos, n, k, soln, solns):
        if len(soln) == k:
            solns.append(soln[:])
        for i in range(pos, n):
            soln.append(i+1)
            self.dfs(i+1, n, k, soln, solns)
            soln.pop()
        