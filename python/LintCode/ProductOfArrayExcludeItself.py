class Solution:
    """
    @param A: Given an integers array A
    @return: An integer array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
    """
    def productExcludeItself(self, A):
        if len(A) == 1:
            return []
        # write your code here
        left = [1]
        for i in range(len(A) - 1):
            left.append(left[-1] * A[i])
        right = [1]
        for i in range(len(A) - 1, 0, -1):
            right.append(right[-1] * A[i])
        right.reverse()
        B = []
        for i in range(len(A)):
            B.append(left[i] * right[i])
        return B