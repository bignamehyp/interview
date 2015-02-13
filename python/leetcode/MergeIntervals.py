# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        if len(intervals) <= 1:
            return intervals
        intervals.sort(key = lambda x:x.start )
        solns = []
        
        for interval in intervals:
            if len(solns) == 0:
                solns.append(interval)
            else:
                if interval.start <= solns[-1].end:
                    solns[-1].end = max(solns[-1].end, interval.end)
                else:
                    solns.append(interval)
        return solns
    
 
