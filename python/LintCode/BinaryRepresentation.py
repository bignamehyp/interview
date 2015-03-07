class Solution:
    #@param n: Given a decimal number that is passed in as a string
    #@return: A string
    def binaryRepresentation(self, n):
        # write you code here
        parts = n.split('.')
        num = int(parts[0])
        frac = float(n) - num
        ans = ''
        if num == 0:
            ans = '0'
        while num > 0:
            ans = str(num % 2) + ans
            num = num >> 1
        if len(parts) == 1:
            return ans
        if frac == 0:
            return ans
        ans += '.'
        ans2 = ''
        while frac > 0.0:
            if len(ans2) > 32:
                return 'ERROR'
            frac *= 2
            if frac >= 1.0:
                ans2 += '1'
                frac -= 1.0
            else:
                ans2 += '0'
            
        return ans + ans2