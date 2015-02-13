class Permutations:
    def permute(self, num):
        solns = []
        if len(num) == 0:return solns
        if len(num) == 1:return [num]
        for pos in range(len(num)):
            for subseq in self.permute(num[0:pos] + num[pos+1:]):
                solns.append( [num[pos]] + subseq)
        return solns
