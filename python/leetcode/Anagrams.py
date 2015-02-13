class Anagrams:
    def anagrams(self, strs):
        dicts = dict()
        for s in strs:
            key = ''.join(sorted(s))
            if key in dicts:
                dicts[key].append(s)
            else:
                dicts[key] = [s]
        solns = []
        for key in dicts:
            if len(dicts[key]) > 1:
                solns.extend(dicts[key])
        
        return solns
            
            