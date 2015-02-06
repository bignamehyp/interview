class SubstringWithCatAllWords:
    def findSubstring(self,S,L):
        if len(L) == 0:return range(len(S))
        wordLen = len(L[0])
        toFind = dict()
        solns = []
        for word in L:
            if not word in toFind:
                toFind[word] = 1
            else:
                toFind[word] += 1
        for i in range(len(S) - wordLen * len(L) + 1 ):
            numMatches = 0
            seen = dict()
            for j in range(len(L)):
                word =  S[i + j * wordLen: i + (j + 1) * wordLen]
                if word in toFind:
                    if word in seen:
                        seen[word] += 1
                    else:
                        seen[word] = 1
                    if seen[word] <= toFind[word]:
                            numMatches+=1
                    else:
                        break
                else:
                    break
            if numMatches == len(L):solns.append(i)
        return solns
