class Solution:
    """
    @param A: An integer array.
    @param k: A positive integer (k <= length(A))
    @param target: Integer
    @return a list of lists of integer 
    """
    def kSumII(self, A, k, target):
        A.sort()
        solns = []
        self.dfs([], A, 0, k, target, solns)
        return solns
    
    def dfs(self, soln, A, start, k, target, solns):
        if k == 0:
            if target == 0:
                solns.append(soln[:])
            return
        
        for i in range(start, len(A) - k + 1):
            if A[i] > target:
                break
            soln.append(A[i])
            self.dfs(soln, A, i + 1, k - 1, target - A[i], solns)
            soln.pop()
        