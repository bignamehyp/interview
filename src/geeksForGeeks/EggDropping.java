package geeksForGeeks;
//http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
public class EggDropping {
	
	static int numDrops(int n, int floors){
		int [][] numDrops = new int[n + 1][floors + 1];
		
		for(int i = 1; i <= n; i++){
			numDrops[i][0] = 0;
			numDrops[i][1] = 1;			
		}
		
		for(int j = 1; j <= floors; j++){
			numDrops[1][j] = j;
		}
		
		for(int i = 2; i <= n; i++)
			for(int j = 1; j <= floors; j++){
				numDrops[i][j] = Integer.MAX_VALUE;
				
				for(int x = 1; x <= j; x++){
					numDrops[i][j] = Math.min(numDrops[i][j], 1 + Math.max(numDrops[i-1][x-1], numDrops[i][j - x]));
				}
			}
		return numDrops[n][floors];
	}
	
	public static void main(String [] args){
		int n = 2, floors = 100;
		System.out.println("Minimum number of trials with " + n + " eggs and " + floors + " floors is " + numDrops(n,floors));
	}
}
