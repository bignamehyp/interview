class MaxSubArray:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self,A):
        maxSum = A[0]
        acSum = 0
        for i in xrange(len(A)):
            acSum += A[i]            
            if acSum > maxSum:
                maxSum = acSum
            if acSum < 0:
                acSum = 0                
        return maxSum