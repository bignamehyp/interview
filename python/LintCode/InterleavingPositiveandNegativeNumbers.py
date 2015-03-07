class Solution:
    """
    @param A: An integer array.
    @return an integer array
    """
    def rerange(self, A):
        if len(A) <= 1:
            return A
        numNeg = 0
         for a in A:
            if a < 0:
                numNeg += 1
        negEnd = 0
        posEnd = 1
        negInd = 0
        if  2 * numNeg < len(A):
            negEnd = 1
            posEnd = 0
            negInd = 1
        for i in range(len(A)):
            if i % 2 == negInd:
                if A[i] >= 0:
                    while posEnd < len(A) and A[posEnd] >= 0:
                        posEnd += 2
                    if posEnd < len(A):
                        A[i], A[posEnd] = A[posEnd], A[i]
            else: 
                if A[i] < 0: 
                    while negEnd < len(A) and A[negEnd] < 0:
                        negEnd += 2
                    if negEnd < len(A):
                        A[i], A[negEnd] = A[negEnd], A[i]
        return A