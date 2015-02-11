class Solution:
    # @return a string
    def countAndSay(self, n):
        i = 1
        ans = '1'
        while i < n:
            temp = ''
            j = 0
            while j < len(ans):
                v = ans[j]
                j += 1
                repeats = 1
                while j < len(ans) and ans[j] == ans[j-1]:
                    j += 1
                    repeats += 1
                temp += str(repeats) + str(v)
            ans = temp
            i += 1
        return ans