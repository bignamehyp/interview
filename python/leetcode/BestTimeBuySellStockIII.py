class BestTimeSellStockIII:
    def maxProfit(self, prices):
        if len(prices) == 0:
            return 0
        dp = [0 for i in range(len(prices))]
        maxProfit = 0
        minPrice = prices[0]
        for i in range(1, len(prices)):
            curProfit = prices[i] - minPrice
            if curProfit > maxProfit:
                maxProfit = curProfit
            if minPrice > prices[i]:
                minPrice = prices[i]
            dp[i] = maxProfit
        
        maxPrice = prices[len(prices) - 1]

        for i in range(len(prices) - 2, 0, - 1):
            curProfit = maxPrice - prices[i]
            if prices[i] > maxPrice:
                maxPrice = prices[i]
            maxProfit = max(maxProfit,  curProfit +dp[i-1])
        return maxProfit
            
