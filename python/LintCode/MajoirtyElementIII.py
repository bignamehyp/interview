class Solution:
    """
    @param nums: A list of integers
    @param k: As described
    @return: The majority number
    """
    def majorityNumber(self, nums, k):
        # write your code here
        counts = {}
        for a in nums:
            if a in counts:
                counts[a] += 1
            else:
                if len(counts) < k:
                    counts[a] = 1
                else:
                    zeros = []
                    for v in counts:
                        counts[v] -= 1
                        if counts[v] == 0:
                            zeros.append(v)
                    for z in zeros:
                        del counts[z]
        argmax = -1
        maxCount = 0
        for v in counts:
            if maxCount < counts[v]:
                maxCount = counts[v]
                argmax = v
        return argmax