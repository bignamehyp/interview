class MinWindowSubstring:
    def minWindow(self, S, T):
        toFind = dict()
        for c in T:
            if c in toFind:
                toFind[c] += 1
            else:
                toFind[c] = 1
        begin = 0
        pos = 0
        numMatches = 0
        found = dict()
        minWin = ""
        minLength = 1 << 32
        
        while pos < len(S):
            if S[pos] in toFind:
                if S[pos] in found:
                    found[S[pos]] += 1
                else:
                    found[S[pos]] = 1
                if found[S[pos]] <= toFind[S[pos]]:
                    numMatches += 1
                if numMatches == len(T):
                    while not S[begin] in found or found[S[begin]] > toFind[S[begin]]:
                        if S[begin] in found:
                            found[S[begin]] -= 1
                        begin += 1
                    if pos - begin + 1 < minLength:
                        minLength = pos - begin + 1
                        minWin = S[begin:pos+1]
            pos += 1
        return minWin
                    

                