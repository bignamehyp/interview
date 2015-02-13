class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        minHash = {}
        maxHash = {}
        for n in num:
            if n in minHash or n in maxHash:
                continue
            if n - 1 not in maxHash and n + 1 not in minHash:
                minHash[n] = n
                maxHash[n] = n
            elif n - 1 in maxHash and n + 1 in minHash:
                start = maxHash[n-1]
                end = minHash[n+1]
                del maxHash[n-1]
                del minHash[start]
                del maxHash[end]
                del minHash[n+1]
                maxHash[end] = start
                minHash[start] = end
            elif n - 1 in maxHash:
                start = maxHash[n-1]
                del maxHash[n-1]
                minHash[start] = n
                maxHash[n] = start
            else:
                end = minHash[n+1]
                del minHash[n+1]
                maxHash[end] = n
                minHash[n] = end
        maxL = 0
        for start in minHash:
            if minHash[start] - start + 1 > maxL:
                maxL = minHash[start] - start + 1
        return maxL
