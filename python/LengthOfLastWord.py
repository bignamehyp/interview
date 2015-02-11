class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        if len(s) == 0:
            return 0
        words = s.strip().split(' ')
        if len(words) == 0:
            return 0
        return len(words[-1])
        