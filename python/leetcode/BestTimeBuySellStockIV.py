class Solution:
    # @return an integer as the maximum profit 
    def maxProfit(self, k, prices):
        if len(prices) == 0:
            return 0
        if k > len(prices):
            maxProfit = 0
            for i in range(1, len(prices)):
                diff = prices[i] - prices[i-1]
                maxProfit += max(diff, 0)
            return maxProfit
            
        local = [0 for j in range(k+1)]
        profit = [0 for j in range(k+1)]
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            for j in range(k, 0, -1):
                local[j] = max(local[j] + diff, profit[j-1] + max(diff, 0))
                profit[j] = max(local[j], profit[j])
        return profit[k]