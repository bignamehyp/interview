class Solution:
    """
    @param a: The first integer
    @param b: The second integer
    @return:  The sum of a and b
    """
    def aplusb(self, a, b):
        # Just submit this code and you will get accepted!
        carry = 0
        res = 0
        for i in range(32):
            x = (a >> i) & 1
            y = (b >> i) & 1
            res |= ((x ^ y) ^ carry) << i
            carry = (x & y) | (x &carry) | (y & carry)
        return res