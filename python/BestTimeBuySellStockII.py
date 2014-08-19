class BestTimeSellStockII:
    def maxProfit(self, profit):
        profit = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            if diff > 0:
                profit = profit + diff
        return profit  