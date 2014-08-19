class LetterComb:
    def letterCombinations(self, digits):
        solns = []
        soln = ""
        phone = {'0':' ', '2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        self.dfs(solns,soln,0, digits, phone)
        return solns
    def dfs(self, solns, soln, pos, digits, phone):
        if pos == len(digits):
            solns.append(soln[:])
            return
        for d in phone[digits[pos]]:
            soln+=d
            self.dfs(solns, soln, pos+1, digits, phone)
            soln = soln[:-1]
        
