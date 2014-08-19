package crack150;

public class Problem9_1 {
	public static int computeWays(int n){
		
		if(n <= 0)
			return 0;
		
		if( n <= 3 )
			return n;
		
		int [] ways = new int [n + 1];
		
		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 3;
		
		for(int i = 4; i <= n; i++){
			ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
		}
		return ways[n];
	}
	
	
	public static void main(String [] args){
		System.out.println(computeWays(10));
	}
	
	
}
