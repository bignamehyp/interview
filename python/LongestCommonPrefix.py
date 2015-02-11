class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        pos = 0
        prefix = ''
        if len(strs) == 0:
            return prefix
        while pos < len(strs[0]):
            c = strs[0][pos]
            for str in strs:
                if pos >= len(str) or str[pos] != c:
                    return prefix
            prefix += c
            pos += 1
        return prefix
                    