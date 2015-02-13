class RemoveDuplicatesFromSortedArray:
    def removeDuplicates(self, A):
        if len(A) <= 1:
            return len(A)
        fast = 1
        slow = 1
        while fast < len(A):
            if A[fast] != A[fast-1]:
                A[slow] = A[fast]
                slow += 1
            fast += 1
        return slow

            
                 
        

            
                    