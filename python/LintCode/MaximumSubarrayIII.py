class Solution:
    """
    @param nums: A list of integers
    @param k: An integer denote to find k non-overlapping subarrays
    @return: An integer denote the sum of max k non-overlapping subarrays
    """
    def maxSubArray(self, nums, k):
        # write your code here
        dp = [ [0 for j in range(k + 1)] for i in range(len(nums) + 1) ]
        for j in range(1, k + 1):
            for i in range(j, len(nums) + 1):
                dp[i][j] = -float('inf')
                cumSum = 0
                subMax = -float('inf')
                for p in range(i-1, j - 2, -1):
                    cumSum = max(nums[p], nums[p] + cumSum)
                    subMax = max(subMax, cumSum)
                    dp[i][j] = max(dp[p][j-1] + subMax, dp[i][j])
        return dp[len(nums)][k]