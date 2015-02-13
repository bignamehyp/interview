class TwoSum:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        mappings = {}
        for i in range(len(num)):
            mappings[num[i]] = i + 1
        for i in range(len(num)) and mappings[val] != i:
            val = target - num[i]
            if val in mappings:
                return [i + 1, mappings[val]]
        return [0,0]
            
                   