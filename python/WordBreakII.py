class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def check(self, s, dict, lenSet):
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        for l in range(1, len(s) + 1):
            for i in lenSet:
                if i > l:
                    continue
                if dp[l-i] and s[l - i : l] in dict:
                    dp[l] = True
                    break
        return dp[len(s)]
        
    def dfs(self, s, dict, stringlist, solns, lenSet):
        if self.check(s, dict, lenSet):
            if len(s) == 0: 
                solns.append(stringlist[1:])
                return
            for i in lenSet:
                if i <= len(s) and s[:i] in dict:
                    self.dfs(s[i:], dict, stringlist+' '+s[:i], solns, lenSet)
    
    def wordBreak(self, s, dict):
        if len(dict) == 0:
            return []
        lenSet = list(set([len(word) for word in dict]))
        lenSet.sort(reverse=True)
        solns = []
        self.dfs(s, dict, '', solns, lenSet)
        return solns
        