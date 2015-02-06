class sqrt:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        if x <= 1:
            return x
        l = 1
        r = x / 2
        while l <= r:
            m = ( l + r ) / 2
            if m * m == x:
                return m
            elif m * m > x:
                r = m  - 1
            else:
                l = m + 1
        return r
