class Solution:
    """
    @param nums: A list of integers
    @return: An integer indicate the value of maximum difference between two
             Subarrays
    """
    def maxDiffSubArrays(self, nums):
        # write your code here
        maxDP = [0 for i in range(len(nums))]
        minDP = [0 for i in range(len(nums))]
        curMin = 0
        curMax = 0
        for i in range(len(nums)-1):
            curMin += nums[i]
            curMax += nums[i]
            if i > 0:
                maxDP[i+1] = max(maxDP[i], curMax)
                minDP[i+1] = min(minDP[i], curMin)
            else:
                maxDP[i+1] = curMax
                minDP[i+1] = curMin
            curMax = max(0, curMax)
            curMin = min(0, curMin)
        maxDiff = 0    
        curMax = 0
        curMin = 0
        for i in range(len(nums) - 1, 0, -1):
            curMax += nums[i]
            curMin += nums[i]
            maxDiff = max(max(curMax - minDP[i], maxDP[i] - curMin), maxDiff)
            curMax = max(0, curMax)
            curMin = min(0, curMin)
        return maxDiff