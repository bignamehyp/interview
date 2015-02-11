class SearchRange:
    def searchRange(self, A, target):
        l = 0
        r = len(A) - 1
        first = -1
        second = -1
        while l <= r:
            m = l + (r-l)/2
            if A[m] == target:
                if m == l or A[m-1] != target:
                    first = m
                    break;
                r = m - 1
            elif A[m] < target:
                l = m + 1
            else:
                r = m - 1
        if l > r:
            return [first,second]
        
        l = 0
        r = len(A) - 1
        while l <= r:
            m = l + (r - l)/2
            if A[m] == target:
                if m == r or A[m+1] != target:
                    second = m
                    break;
                l = m + 1
            elif A[m] > target:
                r = m - 1
            else:
                l = m + 1 
         
        return [first,second]
        