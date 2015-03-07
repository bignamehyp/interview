class Solution:
    """
    @param a, b, n: 32bit integers
    @return: An integer
    """
    def fastPower(self, a, b, n):
        # write your code here
        if n == 0:
            return 1 % b
        if n < 0:
            return self.fastPower(1.0/a, b, -n)
        tmp = self.fastPower(a, b, n/2)
        tmp *= tmp
        if n % 2 == 1:
            tmp *= a%b
        return tmp % b