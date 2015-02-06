class RemoveDuplicatesFromSortedArrayII:
    def removeDuplicates(self, A):
        pos = 0
        length = 0
        while pos < len(A):
            A[length] = A[pos]
            length += 1
            rep = 1
            while pos + 1 < len(A) and A[pos] == A[pos+1]:
                pos += 1
                rep += 1
            if rep > 1:
                A[length] = A[pos]
                length += 1            
            pos += 1
        return length
        

            
                    