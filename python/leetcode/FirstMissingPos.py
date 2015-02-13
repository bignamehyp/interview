class FirstMissingPos:
    def firstMissingPositive(self, A):
        pos = 0
        while pos  < len(A):
            while( A[pos] != pos + 1 and 1 <= A[pos] <= len(A) and A[pos] != A[A[pos]-1] ):
                tmp = A[pos]
                A[pos] = A[tmp-1]
                A[tmp - 1] = tmp
            pos += 1
        pos = 0
        while pos < len(A):
            if A[pos] != pos +1:
                return pos + 1
            pos += 1
        return len(A) + 1
    
        