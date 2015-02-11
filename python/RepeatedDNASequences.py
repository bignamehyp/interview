class Solution:
    # @param s, a string
    # @return a list of strings
    def findRepeatedDnaSequences(self, s):
        L = 10
        mask = (1 << L * 2 ) - 1
        if len(s) < L + 1:
            return []
        dic = {}
        map = {'A' : 0, 'C' : 1, 'G': 2, 'T' : 3}
        soln = []
        key = 0
        for i in range(len(s)):
            key = (key * 4 + map[s[i]]) & mask
            if i < 9:
                continue
            dic[key] = dic.get(key, 0) + 1
            if dic[key] == 2:
                soln.append(s[i-9:i+1])
        return soln