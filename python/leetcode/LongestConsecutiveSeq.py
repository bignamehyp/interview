class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        minHash = {}
        maxHash = {}
        maxLen = 1
        for n in num:
            if n - 1 not in maxHash and n + 1 not in minHash:
                minHash[n] = n
                maxHash[n] = n
            elif n - 1 in maxHash and n + 1 in minHash: #j n - 1, n + 1, j'
                start = maxHash[n-1]
                end = minHash[n+1]
                minHash[start] = end
                maxHash[end] = start
                del minHash[n+1]
                del maxHash[n-1]
                maxLen = max(maxLen, end - start + 1)
            elif n - 1 in maxHash: # j, n -1
                maxHash[n] = maxHash[n-1]
                minHash[maxHash[n-1]] = n
                del maxHash[n-1]
                maxLen = max(maxLen, n - maxHash[n] + 1)
            else:
                minHash[n] = minHash[n+1]
                maxHash[minHash[n+1]] = n
                del minHash[n+1]
                maxLen = max(maxLen, minHash[n] - n + 1)
        return maxLen
        
