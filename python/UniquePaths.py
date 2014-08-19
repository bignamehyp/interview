class UniquePaths:
    def UniquePaths(self, m, n):
        smaller = m
        if m > n: smaller = n
        rez = 1
        for i in range(1, smaller):
            rez = rez * (m + n - 1 - i) / i
        return rez
        