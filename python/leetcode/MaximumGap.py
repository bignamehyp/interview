class Solution:
    # @param num, a list of integer
    # @return an integer
    def maximumGap(self, num):
        if len(num) < 2:
            return 0
        maxN = min(num)
        minN = max(num)
        step = 1.0 * (maxN - minN) / (len(num) - 1)

        maxBins = [-1 for i in range(len(num))]
        minBins = [-1 for i in range(len(num))]
        
        for n in num:
            bin = int(1.0 * (n - minN) / step)
            if maxBins[bin] < 0:
                maxBins[bin] = n
                minBins[bin] = n
            else:
                maxBins[bin] = max(maxBins[bin], n)
                minBins[bin] = min(minBins[bin], n)
        tmp = minN
        maxDist = 0
        for i in range(len(num)):
            if maxBins[i] < 0:
                continue
            maxDist = max(maxDist, minBins[i] - tmp)
            tmp = maxBins[i]
        return maxDist

