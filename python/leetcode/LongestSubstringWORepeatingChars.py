class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        if len(s) == 0:
            return 0
        maxL = 1
        start = 0
        chars = {}
        chars[s[0]] = 0
        for i in range(1, len(s)):
            c = s[i]
            if c in chars:
                newstart = chars[c] + 1
                for j in range(start, chars[c] + 1):
                    del chars[s[j]]
                start = newstart
            maxL = max(maxL, i - start +1)
            chars[c] = i
        return maxL  