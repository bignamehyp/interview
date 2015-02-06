class LargestNumber:
    # @param num, a list of integers
    def compare(self, a, b):
        if a == b:
            return 0
        return -1 if (str(a) + str(b)) < (str(b) + str(a)) else 1
    # @return a string
    def largestNumber(self, num):
        num.sort(reverse=True, cmp=self.compare)
        res = ''.join([str(n) for n in num])
        res = res.lstrip('0')
        if res == '':
            return '0'
        return res