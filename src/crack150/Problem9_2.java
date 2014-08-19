package crack150;

public class Problem9_2 {
	
	public static int computeWays(int x, int y){
		if(x < 0 || y < 0) return 0;
		
		int [][] ways = new int[x+1][y+1];
		for(int ix = 0; ix <= x; ix++){
			ways[ix][0] = 1;
		}
		for(int iy = 0; iy <= y; iy++){
			ways[0][iy] = 1;
		}
		
		for(int ix = 1; ix <= x; ix++){
			for(int iy = 1; iy <= y; iy++){
				ways[ix][iy] = ways[ix-1][iy] + ways[ix][iy-1];
			}
		}
		return ways[x][y];
	}
	
	
	public static void main(String [] args){
		System.out.println(computeWays(10,5));
	}
}
