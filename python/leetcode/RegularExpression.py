class RegularExpression:
    def isMatch(self, s, p):
        s, p = ' ' + s, ' ' + p
        dp = [[False] * (len(p)) for i in range(len(s))]
        dp[0][0] = True
        ind = 2
        while ind < len(p) and p[ind] == '*':
            dp[0][ind], ind = True, ind + 2
        for i in range(1, len(s)):
            for j in range(1, len(p)):
                if (s[i] == p[j] or p[j] == '.') and dp[i-1][j-1]:
                    dp[i][j] = True
                if p[j] == '*' and (dp[i][j-2] or ((p[j-1] == '.' or p[j-1] == s[i]) and (dp[i-1][j-2] or dp[i-1][j]))):
                    dp[i][j] = True
        return dp[len(s) - 1][len(p) - 1]
        