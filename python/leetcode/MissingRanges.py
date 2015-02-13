"""
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
"""
class Solution:
    def findMissingRanges(self, vals, lower, upper):
        l = []
        start = lower
        l.append(lower)
        for v in vals:
            if v > lower and v < upper:
                l.append(v)
        l.append(upper)
        return self.makeRange(l)

    def makeRange(self, l):
        solns = []
        start = l[0] + 1
        i = 1
        while i < len(l):
            while l[i] == l[i-1] + 1:
                start = l[i] + 1
                i += 1
            if l[i] - 1 == start:
                solns.append(str(start))
            else:
                solns.append(str(start) + "->" + sr(l[i]-1) )
        return solns
            