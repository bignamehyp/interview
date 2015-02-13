'''
Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example,
Given S = “eceba”,
T is “ece” which its length is 3.
baaaac
'''
class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s):
        start = 0
        lastEnd = -1
        maxLen = 0
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                continue
            if lastEnd >= 0 and s[i] != s[lastEnd]:
                maxLen = max(maxLen, i - start)
                start = lastEnd + 1
            lastEnd = i -1
        return max(maxLen, len(s) - start)