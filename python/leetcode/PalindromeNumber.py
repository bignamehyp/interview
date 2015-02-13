class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:
            return False
        y = x
        d = 0
        while y > 0:
            y /= 10
            d += 1
        l = 0
        r = d - 1
        while l < r:
            base1 = 10 ** l
            base2 = 10 ** r
            r2 = (x / base2) % 10
            r1 = (x / base1) % 10
            if r1 != r2:
                return False
            l += 1
            r -= 1
            
        return True