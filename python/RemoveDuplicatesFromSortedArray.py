class RemoveDuplicatesFromSortedArray:
    def removeDuplicates(self, A):
        pos = 0
        length = 0
        while pos < len(A):
            A[length] = A[pos]
            length += 1
            while pos + 1 < len(A) and A[pos] == A[pos+1]:
                pos += 1
            pos += 1
        return length
            
                 
        

            
                    