class FindMinInRotatedSortedArrayII:
    def findMin(self, num):
        l = 0
        r = len(num) - 1
        while l <= r:
            m = ( l + r ) / 2
            if l == r:
                return num[l]
            if l + 1 == r:
                return min(num[l], num[r])
            if num[l] == num[m]:
                l += 1
            elif num[l] < num[m]:
                if num[r] > num[l]:
                    return num[l]
                else:
                    l = m + 1
            else:
                if num[m-1] > num[m]:
                    return num[m]
                else:
                    r = m - 1
        return num[r]
        
