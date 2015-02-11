class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        ans = '0'
        for s in range(len(num1)):
            m = self.mul(num2, num1[s])
            if m != '0':
                m = m + '0' * (len(num1) - s - 1)
            ans = self.add(ans, m)
        return ans
        
    def mul(self, num1, d):
        carry = 0
        d = int(d)
        if d == 0:
            return '0'
        ans = ''
        for i in range(len(num1) - 1, -1, -1):
            v = int(num1[i]) * d + carry
            if v >= 10:
                carry = v / 10
                v = v % 10
            else:
                carry = 0
            ans = str(v) + ans
        if carry > 0:
            ans = str(carry) + ans
        return ans
            
        
            
    def add(self, num1, num2):
        carry = 0
        pos1 = len(num1) - 1
        pos2 = len(num2) - 1
        res = ''
        while pos1 >= 0 or pos2 >= 0:
            v1 = 0
            if pos1 >= 0:
                v1 = int(num1[pos1])
                pos1 -= 1
            v2 = 0
            if pos2 >= 0:
                v2 = int(num2[pos2])
                pos2 -= 1
            v = carry + v1 + v2
            if v >= 10:
                v -= 10
                carry = 1
            else:
                carry = 0
            res = str(v) + res
        if carry > 0:
            res = str(carry) + res
        return res