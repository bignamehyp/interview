class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
        if len(dict) == 0:
            return len(s) == 0
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        lenSet = list(set([len(word) for word in dict]))
        lenSet.sort(reverse=True)
        for l in range(1, len(s) + 1):
            for i in lenSet:
                if i > l:
                    continue
                if dp[l-i] and s[l - i : l] in dict:
                    dp[l] = True
                    break
        return dp[len(s)]