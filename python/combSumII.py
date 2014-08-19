class CombSumII:
    def combinationSum2(self, candidates, target):
        solns = []
        soln = []
        candidates = sorted(candidates)
        self.dfs(solns, soln, candidates, target )
        return solns
    def dfs(self, solns, soln, candidates, target):
        if target == 0:
            solns.append(soln[:])
            return
        pos = 0
        while pos  < len(candidates):
            num = candidates[pos]
            if num > target:
                break
            else:
                soln.append(num)
                self.dfs(solns, soln, candidates[pos+1:], target - num)
                soln.pop()
            while pos + 1< len(candidates) and candidates[pos] == candidates[pos+1]:
                pos+=1
            pos += 1
        
            