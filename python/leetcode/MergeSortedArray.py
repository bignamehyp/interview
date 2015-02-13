class MergeSortedArray:
    def merge(self, A, m, B, n):
        if B is None or n == 0: return A
        iter_A = m - 1
        iter_B = n - 1
        iter_m = m + n - 1
        while iter_A >= 0 and iter_B >= 0:
            if A[iter_A] < B[iter_B]:
                A[iter_m] = B[iter_B]
                iter_m -= 1
                iter_B -= 1
            else:
                A[iter_m] = A[iter_A]
                iter_m -= 1
                iter_A -= 1
        if iter_B >= 0:
            while iter_B  >= 0:
                A[iter_B] = B[iter_B]
                iter_B -= 1
        return
        
        
    