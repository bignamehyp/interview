class Solution:
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s):
        solns = []
        self.dfs([], s, solns)
        return solns
    def dfs(self, soln, s, solns):
        if s == '' or len(soln) == 4:
            if s == '' and len(soln) == 4:
                solns.append('.'.join(soln))
            return
    
        soln.append(s[:1])
        self.dfs(soln, s[1:], solns)
        soln.pop()
        
        if s[0] != '0' and len(s) > 1:
            soln.append(s[:2])
            self.dfs(soln, s[2:], solns)
            soln.pop()
        if s[0] != '0' and len(s) > 2 and int(s[:3]) <= 255:
            soln.append(s[:3])
            self.dfs(soln, s[3:], solns)
            soln.pop()