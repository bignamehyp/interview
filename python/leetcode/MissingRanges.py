"""
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
"""
class Solution:
    # @param A, a list of integers
    # @param lower, an integer
    # @param upper, an integer
    # @return a list of strings
    def findMissingRanges(self, A, lower, upper):
        soln = []
        if len(A) == 0:
            self.printSoln(soln, lower, upper)
            return soln
        i = 0
        while i < len(A) and A[i] < lower:
                i += 1
        if i == len(A):
            return soln
        pre = A[i]
        if A[i] > lower:
            self.printSoln(soln, lower, A[i] - 1)
        i += 1
        while i < len(A) and A[i] <= upper:
            if A[i] != pre + 1:
                self.printSoln(soln, pre+1, A[i] -1)
            pre = A[i]
            i += 1
        if i == len(A):
            self.printSoln(soln, pre+1, upper)
        return soln
    def printSoln(self, soln, a, b):
        if a > b:
            return
        if a == b:
            soln.append(str(a))
        else:
            soln.append(str(a) + '->' + str(b))