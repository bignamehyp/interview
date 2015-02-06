class FindMinInRotatedSortedArray:
    def findMin(self, num):
        l = 0
        r = len(num) - 1
        while l <= r:
            m = (l + r)/2
            if l == r: return num[l]
            if r == l + 1: return min(num[l], num[r])    
            if num[m] < num[m+1] and num[m] < num[m-1]:
                return num[m]
            if num[m] <= num[r]:
                r = m - 1
            else:
                l = m + 1
        return num[l]