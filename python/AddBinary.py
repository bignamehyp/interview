class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        p1 = len(a) - 1
        p2 = len(b) - 1
        carry = 0
        res = ''
        while p1 >= 0 or p2 >= 0:
            v1 = 0
            if p1 >= 0:
                v1 = int(a[p1])
                p1 -= 1
            v2 = 0
            if p2 >= 0:
                v2 = int(b[p2])
                p2 -= 1
            v = v1 + v2 + carry
            if v >= 2:
                v -= 2
                carry = 1
            else:
                carry = 0
            res = str(v) + res
        if carry > 0:
            res = str(carry) + res
        return res