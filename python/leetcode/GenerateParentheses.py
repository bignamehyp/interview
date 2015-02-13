class GenerateParentheses:
    def generateParenthesis(self, n):
        solns = []
        self.parents(n,n, [], solns)
        return solns

    def parents(self, nL, nR,soln,solns):
        if nL > nR or nL < 0:
            return
        elif nL == 0 and nR == 0:
            solns.append(''.join(soln))
        else:
            soln.append('(')
            self.parents(nL-1, nR, soln,solns)
            soln.pop()
            soln.append(')')
            self.parents(nL, nR-1, soln,solns)
            soln.pop()