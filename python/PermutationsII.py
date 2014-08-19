class PermutationsII:
    def permuteUnique(self, num):
        if len(num) == 0: return [[]]
        if len(num) == 1: return [num]
        num.sort()
        solns = []
        preVal = None
        for i in range(len(num)):
            if num[i] == preVal:
                continue
            preVal = num[i]
            for parts in self.permuteUnique(num[:i] + num[i+1:] ):
                solns.append( [num[i]] + parts )
        return solns