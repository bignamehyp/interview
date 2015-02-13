class LongestPalindromicSubstr:
    def longestPalindrome(self,s):
        if s is None:
            return None
        longest = 1
        substr = s[0]
        for i in range(len(s)):
            before = i - 1
            after = i + 1
            while before >= 0 and after < len(s) and s[before] == s[after]:
                length = after - before + 1
                if length > longest:
                    longest = length
                    substr = s[before:after+1]
                before -= 1
                after += 1
 
            before = i
            after = i + 1
            while before >= 0 and after < len(s) and s[before] == s[after]:
                length = after - before + 1
                if length > longest:
                    longest = length
                    substr = s[before:after+1]
                before -= 1
                after += 1
        return substr