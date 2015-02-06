class SearchInsertPos:
    def searchInsert(self, A, target):
        l = 0
        r = len(A) - 1
        while l <= r:
            m = l + (r - l) / 2
            if A[m] == target:
                return m
            elif A[m] < target:
                l = m + 1
            else:
                r = m - 1
        return l
        