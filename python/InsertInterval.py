class InsertInterval:
    def insert(self,intervals, newInterval):
        solns = []
        for interval in intervals:
            if interval.end < newInterval.start or interval.start > newInterval.end:
                solns.append(interval)
            else:
                newInterval.start = min(newInterval.start, interval.start)
                newInterval.end = max(newInterval.end, interval.end)
        
        if len(solns) == 0:
            solns.append(newInterval)

        for i in range(len(solns)):
            if solns[i].start > newInterval.start:
                solns = solns[0:i] + [newInterval] + solns[i:]
                break
        if solns[len(solns)-1].start < newInterval.start:
            solns.append(newInterval)

        return solns
                
