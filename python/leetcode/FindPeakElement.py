class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        if len(num) <= 1:
            return 0
        if num[0] > num[1]:
            return 0
        if num[len(num)-1] > num[len(num)-2]:
            return len(num) - 1
        l = 1
        r = len(num) - 2
        while l <= r:
            m = l + (r - l) / 2
            if num[m-1] < num[m] and num[m+1] < num[m]:
                return m
            elif num[m-1] < num[m] < num[m+1]:
                l = m + 1
            elif num[m-1] > num[m] > num[m+1]:
                r = m - 1
            else:
                l = m + 1
        return -1