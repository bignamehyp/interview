class NextPermutation:
    def nextPermutation(self, num):
        argmax = len(num) - 1
        maxVal = num[argmax]
        pos = argmax - 1
        while pos >= 0:
            if num[pos] >= maxVal:
                maxVal = num[pos]
                argmax = pos
                pos-=1
            else:
                break
        if argmax == 0:
            return num[::-1]
        pos = len(num) - 1
        while pos >= argmax:
            if num[pos] <= num[argmax-1]:
                pos-=1
            else:
                break;

        tmp = num[argmax-1]
        num[argmax-1] = num[pos]
        num[pos] = tmp
        sublist = num[argmax:len(num)]
        return num[:argmax] + sublist[::-1]
        