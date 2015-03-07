class CombSum:
    def combinationSum(self, candidates, target):
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
                self.dfs(solns, soln, candidates[pos:], target - num)
                soln.pop()
            pos += 1
    def combinationSumDP(self, candidates, target):
        candidates.sort()
        dp = []
        dp.append([])
        for t in range(1, target + 1):
            solns = []
            for val in candidates:
                if val > t:
                    break
                if val == t:
                    solns.append([val])
                else:
                    for soln in dp[t-val]:
                        if val >= soln[-1]:
                            solns.append(soln[:] + [val])
            dp.append(solns)
        return dp[target]
            