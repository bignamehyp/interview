class MedianOfTwoSortedArray:
    def findMedianSortedArrays(self, A, B):
        l1 = len(A)
        l2 = len(B)
        if (l1 + l2) % 2 == 1:
            return self.findK( (l1 + l2)/2, A, 0, len(A) -1, B, 0, len(B) -1 )
        else:
            return 0.5 * (self.findK( (l1 + l2)/2 - 1, A, 0, len(A) -1, B, 0, len(B) -1  ) + self.findK( (l1 + l2)/2, A, 0, len(A) -1, B, 0, len(B) -1  ) )


    def findK(self,k , A, lA, rA, B, lB, rB):
        l1 = rA - lA + 1
        l2 = rB - lB + 1
        if l1 == 0:
            return B[lB + k]
        if l2 == 0:
            return A[lA + k]
            
        if k == 0:
            return min(A[lA],B[lB])
            
        mA = k * l1 / (l1 + l2)
        mB = k - mA - 1

        if A[lA + mA] < B[lB + mB]:
            return self.findK( mB, A, lA+mA + 1, rA, B, lB, lB + mB )
        else:
            return self.findK( mA, A, lA, lA+mA, B, lB+mB +1, rB )