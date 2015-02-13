class SearchRotatedSortedArray:
    def search(self, A, target):
        l = 0
        r = len(A) - 1
        while l <= r:
            m = l + (r-l)/2
            if A[m] == target:
                return m
            elif A[l] <= A[m]:
                if A[l] <= target < A[m]:
                    r = m - 1
                else:
                    l = m + 1
            else:
                if A[m] < target <= A[r]:
                    l = m + 1
                else:
                    r = m - 1
        return -1
