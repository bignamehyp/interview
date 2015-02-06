package crack150;

public class Problem9_8 {
	
	public static void printAllWays(int n, final int [] coins){
		int [] numCoins = new int [coins.length];
		printAllWays(n, coins, numCoins, 0);		
	}
	
	public static void printAllWays(int n, final int [] coins, int [] numCoins, int coinIdx){
		if(coinIdx <  0)
			return;
		 
		if(coinIdx == coins.length - 1){				
			numCoins[coinIdx] = n / coins[coinIdx];
			for(int i = 0; i < numCoins.length; i++){
				System.out.print( coins[i] + "x" + numCoins[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int numCoin = 0; numCoin <= n / coins[coinIdx]; numCoin++){
			numCoins[coinIdx] = numCoin;
			printAllWays(n - numCoins[coinIdx] * coins[coinIdx],  coins, numCoins, coinIdx + 1);
		}
		
	}
	
	public static void main(String [] args){
		int [] coins = new int[4];
		coins[0] = 25;
		coins[1] = 10;
		coins[2] = 5;
		coins[3] = 1;
		
		printAllWays(99, coins);
	}
}
