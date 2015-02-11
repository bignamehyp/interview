class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S):
        solns = []
        S.sort()
        N = 2**len(S)
        for k in range(N):
            soln = []
            l = 0
            while k > 0:
                if k % 2 == 1:
                    soln.append(S[l])
                k = k / 2
                l += 1
            solns.append(soln)
        return solns