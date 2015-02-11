class fourSum:
    def fourSum(self, num, target):
        num.sort()
        i = 0
        solns = []
        while i < len(num) - 3:
            i2 = i + 1
            while i2 < len(num) - 2:
                if num[i2] > 0 and num[i] + num[i2] > target:
                    i2 += 1
                    continue
                j = i2 + 1
                k = len(num) - 1
                while j < k:
                    curSum = num[i] + num[i2] + num[j] + num[k]
                    if curSum == target:
                        solns.append([num[i], num[i2], num[j], num[k]])
                    if curSum <= target:
                        j += 1
                        while j < len(num) and num[j] == num[j-1]:
                            j += 1
                    if curSum >= target:
                        k -= 1
                        while k >= 0 and num[k] == num[k+1]:
                            k -= 1
                i2 += 1
                while i2 < len(num) - 2 and num[i2] == num[i2-1]:
                    i2 += 1
            i += 1
            while i < len(num) - 3 and num[i] == num[i-1]:
                    i += 1
        return solns