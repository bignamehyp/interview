class PermutationSeq:
    def getPermutation(self, n, k):
        fact = 1
        for i in range(2, n+1):
            fact *= i            
        soln = []
        candidates = [str(i) for i in range(1, n+1)]        
        for i in range(n):
            fact = fact / (n - i)
            index  = (k-1) / fact
            k = k - index * fact
            soln.append(candidates[index])
            candidates = candidates[:index] + candidates[index+1:]
        return ''.join(soln)