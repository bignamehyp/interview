class Solution:
    def isScramble(self, s1, s2):
        if len(s1)!=len(s2): return False
        if s1==s2: return True
        if sorted(s1)!=sorted(s2): return False
        for i in range(1,len(s1)):
            if self.isScramble(s1[:i],s2[:i]) and \
               self.isScramble(s1[i:],s2[i:]):
                return True
            if self.isScramble(s1[:i],s2[-i:]) and \
               self.isScramble(s1[i:],s2[:-i]):
                return True
        return False
        
    # @return a boolean
    def isScrambleDP(self, s1, s2):
        if len(s1) != len(s2):
            return False
        if s1 == s2:
            return True
        if sorted(s1) != sorted(s2):
            return False
            
        dp = [[[False for i in range(len(s1))]for j in range(len(s1))] for n in range(len(s1))]
        
        for i in range(len(s1)):
            for j in range(len(s1)):
                dp[0][i][j] = s1[i] == s2[j]
        
        for n in range(1, len(s1)):
            for i in range(len(s1) - n):
                for j in range(len(s1) - n):
                    if j + n >= len(s1):
                        break
                    for div in range(1, n+1):
                        l1 = div - 1
                        l2 = n - div
                        if dp[l1][i][j] and dp[l2][i+div][j+div]:
                            dp[n][i][j] = True
                            break
                        if dp[l1][i][j+l2+1] and dp[l2][i+div][j]:
                            dp[n][i][j] = True
                            break
        
        return dp[len(s1)-1][0][0]