class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers includes the index of the first number 
             and the index of the last number
    """
    def subarraySum(self, nums):
        # write your code here
        sumTable = {}
        sumTable[0] = 0
        curSum = 0
        for i in range(len(nums)):
            curSum += + nums[i]
            if curSum in sumTable:
                return [sumTable[curSum], i]
            else:
                sumTable[curSum] = i + 1
        