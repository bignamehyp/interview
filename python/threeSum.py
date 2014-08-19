class threeSum:
    def threeSum(sef,num):
        num.sort()
        solns = []
        for first in xrange(len(num)-2):
            if first == 0 or first > 0 and num[first] != num[first - 1]:
                second = first + 1
                third = len(num) - 1
                while second < third:               
                    cursum = num[first] + num[second] + num[third] 
                    if cursum == 0:
                        solns.append([num[first],num[second], num[third]])
                        second += 1
                        third -= 1
                        while second < third and num[second] == num[second - 1]:
                            second += 1
                        while second < third and num[third] ==  num[third + 1]:
                            third -= 1
                    elif cursum < 0:
                        second += 1
                    else:
                        third -= 1
        return solns
            
                   