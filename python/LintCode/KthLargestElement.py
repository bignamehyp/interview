class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        return self.quickSelect(len(A) - k, A, 0, len(A) - 1)
        
    def quickSelect(self, k, A, l, r):
        if l == r:
            return A[k]
        m = l + ( r - l ) / 2
        A[m], A[r] = A[r], A[m]
        pivot = A[r]
        rr = r - 1
        ll = l
        while ll <= rr:
            if A[ll] >= pivot:
                A[ll], A[rr] = A[rr], A[ll]
                rr -= 1
            else:
                ll += 1
        m = ll
        A[m], A[r] = A[r], A[m]
        if k == m:
            return A[k]
        if k < m:
            return self.quickSelect(k, A, l, m - 1)
        else:
            return self.quickSelect(k, A, m + 1, r)