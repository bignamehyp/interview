class Solution:
    # @param A: Given an integer array
    # @return: void
    def heapify(self, A):
        # write your code here
        if len(A) <= 1:
            return
        lastParent = (len(A) - 2) / 2
        while lastParent >= 0:
            self.shiftDown(A, lastParent, len(A) - 1)
            lastParent -= 1
        
    def shiftDown(self, A, start, end):
        while 2 * start + 1 <= end:
            child = 2 * start + 1
            if child + 1 <= end and A[child + 1] < A[child]:
                child = child + 1
            if A[start] > A[child]:
                A[start], A[child] = A[child], A[start]
                start = child
            else:
                break
                
    def heapify2(self, A):
        for i in range(1, len(A)):
            child = i
            parent = (i - 1) / 2
            while parent >= 0 and A[parent] > A[child]:
                A[child], A[parent] = A[parent], A[child]
                child = parent
                parent = (parent - 1) / 2
                