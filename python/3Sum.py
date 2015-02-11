class threeSum:
    def threeSum(sef,num):
        num.sort()
        i = 0
        solns = []
        while i < len(num) - 2:
            j = i + 1
            k = len(num) - 1
            while j < k:
                curSum = num[i] + num[j] + num[k]
                if curSum == 0:
                    solns.append([num[i], num[j], num[k]])
                if curSum <= 0:
                    j += 1
                    while j < len(num) and num[j] == num[j-1]:
                        j += 1
                if curSum >= 0:
                    k -= 1
                    while k >= 0 and num[k] == num[k+1]:
                        k -= 1
            i += 1
            while i < len(num) - 2 and num[i] == num[i-1]:
                    i += 1
        return solns
            
                   