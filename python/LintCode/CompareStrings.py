class Solution:
    """
    @param A : A string includes Upper Case letters
    @param B : A string includes Upper Case letters
    @return :  if string A contains all of the characters in B return True else return False
    """
    def compareStrings(self, A, B):
        # write your code here
        A = ''.join(c for c in A if c.isupper())
        B = ''.join(c for c in B if c.isupper())
        if B == "":
            return True
        if A == "":
            return False
        
        histB = {}
        for b in B:
            histB[b] = histB.get(b, 0) + 1
        L = 0
        histA = {}
        for a in A:
            histA[a] = histA.get(a, 0) + 1
            if a in histB and histA[a] <= histB[a]:
                L += 1
        return L == len(B)