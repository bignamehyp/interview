class Solution:
    """
    @param L: Given n pieces of wood with length L[i]
    @param k: An integer
    return: The maximum length of the small pieces.
    """
    def woodCut(self, L, k):
        # write your code here
        if len(L) == 0:
            return 0
        l = 1
        r = max(L)
        while l <= r:
            m = l + (r - l) / 2
            numPieces = sum([wood/m for wood in L])
            if numPieces >= k: #find larger 
                l = m + 1
            else:
                r = m - 1
        return r