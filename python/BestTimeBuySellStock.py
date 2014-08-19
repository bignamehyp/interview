class BestTimeSellStock:
    def maxProfit(self, prices):
        if len(prices) == 0:
            return 0
        minPrice = prices[0]
        maxProfit = 0
        for i in range(len(prices)):
            curProfit = prices[i] - minPrice
            if curProfit > maxProfit:
                maxProfit = curProfit
            if minPrice > prices[i]:
                minPrice = prices[i]
        return maxProfit
