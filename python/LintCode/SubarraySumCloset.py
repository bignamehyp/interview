class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers includes the index of the first number 
             and the index of the last number
    """
    def subarraySumClosest(self, nums):
        # write your code here
        sumTable = {}
        sumTable[0] = -1
        curSum = 0
        for i in range(len(nums)):
            curSum += nums[i]
            if curSum in sumTable:
                return [sumTable[curSum] + 1, i]
            else:
                sumTable[curSum] = i
        sumArray = list(sumTable.keys())
        sumArray.sort()
        minDiff = float('inf')
        l = -1
        r = -1
        for i in range(1, len(sumArray)):
            diff = sumArray[i] - sumArray[i-1]
            if diff < minDiff:
                minDiff = diff
                l = sumTable[sumArray[i]]
                r = sumTable[sumArray[i-1]]
                if l > r:
                    l, r = r, l
        return [l+1, r]