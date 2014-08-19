package leetcode;

public class MaxProfit {
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
	
	public  int maxProfit2(int[] prices) {
	    int [] first = new int [prices.length];
	    int max = 0;
	    int cumSum = 0;
	    for(int i = 1; i < prices.length ; i ++){
	        int diff = prices[i] - prices[i - 1];
	        cumSum += diff;
	        if(cumSum < 0){
	            cumSum = 0;
	        }else{
	            if(cumSum > max){
	                max = cumSum;
	            }
	        }
	        first[i] = max; //sell at i  
	    }
	    
	    cumSum = 0;
 	    for(int i = prices.length - 2; i >= 2; i--){
	        int diff = prices[i+1] - prices[i];
	        cumSum += diff;
	        if(cumSum < 0){
	            cumSum = 0;
	        } else if(cumSum + first[i - 1] > max){
	            max = cumSum + first[i - 1];
	        }
	        
	    }
	    return max;
	    
    }
	
	 public int maxProfit(int[] prices) {
 	        int profit = 0;
 	        
	        for(int i = 1; i < prices.length; i++){
	        	int diff = prices[i] - prices[i-1];
	        	if( diff > 0)
	        		profit += diff; 
	        }
	        return profit;
	    }
	 
	 
	 public int maxProfitOneTxn(int[] prices) {
		 	int maxProfit = 0;
	        int curProfit = 0;
	        for(int i = 1; i < prices.length;  i++){
	            int diff = prices[i] - prices[i-1];
	            curProfit += diff;
	            if(curProfit > maxProfit)
	               maxProfit = curProfit;
	            if(curProfit < 0 )
	                curProfit = 0;
	        }
	        return maxProfit;
	    }
	 
	 public static void main(String [] args){
		 int[] prices =  {1,2};
		 MaxProfit mp = new MaxProfit();
		 mp.maxProfit2(prices);
		}
}
