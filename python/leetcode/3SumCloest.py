class threeSumClosest:
    def threeSumClosest(sef,num,target):
        num = sorted(num)
        first = 0
        minDiff = 1 << 32
        cloeset = 0
        for first in range(len(num) - 2):
            second = first + 1
            third = len(num) - 1
            while second < third:
                cursum = num[first] + num[second] + num[third]
                if cursum == target:
                    return target
                elif cursum < target:
                    second+=1
                else:
                    third -= 1
                diff = abs( target -  cursum)
                if diff < minDiff:
                    minDiff = diff
                    cloeset = cursum
        return cloeset
                   