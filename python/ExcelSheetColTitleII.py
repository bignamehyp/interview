class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        base = 26
        d = len(s) - 1
        ans = 0
        while d >= 0:
            c = s[len(s) - 1 - d]
            ans += (ord(c) - 64) * (base ** d)
            d -= 1
        return ans