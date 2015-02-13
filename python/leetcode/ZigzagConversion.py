class Solution:
    # @return a string
    def convert(self, s, nRows):
        if nRows == 1:
            return s
        k = nRows * 2 - 2
        rows = ["" for i in range(nRows)]
        for i in range(len(s)):
            r = i % k 
            if r < nRows:
                rows[r] += s[i]
            else:
                rows[k - r] += s[i] 
        return ''.join(rows)