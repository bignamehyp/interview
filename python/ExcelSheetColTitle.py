class Solution:
    # @return a string
    def convertToTitle(self, num):
        base = 26
        ans = ''
        while num  > 0:
            reminder = num % base
            if reminder == 0:
                reminder = base
            num = (num - reminder) / base
            ans = chr(reminder + 64) + ans
        return ans
            