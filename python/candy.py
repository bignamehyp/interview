class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        if len(ratings) == 1:
            return 1
        minRating = min(ratings)
        candy = [0 for i in range(len(ratings))]
        
        for i in range(len(ratings)):
            candy[i] = ratings[i] - minRating - 1
        
        candy[0] = 1
        
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candy[i] = candy[i-1] + 1
            else:
                candy[i] = 1
                
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i+1]:
                candy[i] = max(candy[i], candy[i+1] +1)
            
        return sum(candy)

