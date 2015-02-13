"""
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?
"""

class Solution:
    def reverseWords(self, s):
        l = 0
        r = len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1
        start = 0
        i = 0
        while i < len(s) + 1:
            if i == len(s) or s[i] == ' ':
                l = start
                r = i - 1
                while l < r:
                    s[l], s[r] = s[r], s[l]
                    l += 1
                    r -= 1
                start = i + 1
            i += 1