class TwoSum:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        mappings = {}
        for i, n in enumerate(num):
            if target - n in mappings:
                return [mappings[target-n] + 1, i + 1]
            mappings[n] = i
        return [0,0]
            
                   