class GasStation:
    def canCompleteCircuit(self, gas, cost):
        lenth = len(gas)
        sum = 0
        curSum = 0
        index = 0
        for i in range(lenth):
            sum += gas[i] - cost[i]
            curSum += gas[i] - cost[i]
            if curSum < 0:
                curSum = 0
                index = i + 1
        if sum < 0:return -1
        return index
