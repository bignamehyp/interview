class SubstringWithCatAllWords:
    def findSubstring(self,S,L):
        if len(S) == 0 or len(L) == 0:
            return []
        length = len(L[0])
        target = {}
        for l in L:
            target[l] = 1 if l not in target else target[l] + 1
        solns = []
        for i in range(len(S) - length * len(L) + 1):
            founds = {}
            found = 0
            for k in range(len(L)):
                candidate = S[i+k*length:i+(k+1)*length]
                if candidate not in target:
                    break
                founds[candidate] = 1 if candidate not in founds else founds[candidate] + 1
                if founds[candidate] <= target[candidate]:
                    found += 1
                else:
                    break
            if found == len(L):
                solns.append(i)
        return solns