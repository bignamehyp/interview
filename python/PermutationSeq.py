class PermutationSeq:
    def getPermutation(self, n, k):
        fact = [0 for i in range(n)]
        fact[0] = 1
        for i in range(1,n):
            fact[i] = fact[i-1]*i

        candidates = [i + 1 for i in range(n)]
        level  = n - 1
        soln = []
        while level >= 0:
            rank = (k - 1) / fact[level]
            soln += str(candidates[rank])
            candidates = candidates[:rank] + candidates[rank+1:]
            k -= rank * fact[level]
            if k < 0: k = 0
            level -= 1
        return soln