class Solution:
    """
    @param nums: A list of integers.
    @return: An integer denotes the middle number of the array.
    """
    def median(self, nums):
        # write your code here
        if len(nums) == 0:
            return 0
        return self.quickSelect(nums, (len(nums) - 1)/2, 0, len(nums)-1)
        
    def quickSelect(self, nums, k, left, right):
        if left >= right:
            return nums[k]
        m = left + (right - left) / 2
        pivot = nums[m]
        nums[m], nums[right] = nums[right], nums[m]
        p = left
        l = left
        while l < right:
            if nums[l] < pivot:
                nums[l], nums[p] = nums[p], nums[l]
                p += 1
            l += 1
        nums[p], nums[right] = nums[right], nums[p]
        if p == k:
            return nums[p]
        elif k < p:
            return self.quickSelect(nums, k, left, p - 1)
        else:
            return self.quickSelect(nums, k, p + 1, right)