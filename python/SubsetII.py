class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        solns = []
        S.sort()
        self.dfs([], 0, S, solns)
        return solns
        
    def dfs(self, soln, pos, S, solns):
        solns.append(soln[:])
        i = pos
        while i < len(S):
            soln.append(S[i])
            self.dfs(soln, i + 1, S, solns)
            soln.pop()
            i += 1
            while i < len(S) and S[i] == S[i-1]:
                i += 1
