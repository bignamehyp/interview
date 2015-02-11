class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        if len(needle) == 0:
            return 0
        if len(haystack) < len(needle):
            return -1 
        L = len(needle)
        mask = (1 << L * 8) - 1
        keyNeedle = 0
        for i in range(len(needle)):
            keyNeedle = (keyNeedle << 8) + ord(needle[i])
        key = 0
        for i in range(len(haystack)):
            key = ((key << 8) + ord(haystack[i])) & mask
            if i < len(needle) - 1:
                continue
            if key == keyNeedle:
                return i - L + 1
        return -1