class MajorityElement:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        ans = num[0]
        count = 1
        for j in range(1, len(num)):
            if num[j] == ans:
                count += 1
            else:
                count -= 1
            if count < 0:
                ans = num[j]
                count = 1
        return ans