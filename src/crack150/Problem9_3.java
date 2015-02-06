package crack150;

public class Problem9_3 {
	
	
	public static int magicIndex(int[] A){
		return binarySearch(A,   0, A.length - 1);
	}
	
	public static int binarySearch(int[] A, int begin, int end){
		if(A == null || end < begin || end >= A.length ){
			return -1;
		}
		
		int middle = begin + ( end - begin ) / 2;
		
		if(A[middle] == middle){
			return middle;
		}
		
		int left = binarySearch(A, begin, Math.min(middle - 1, A[middle]));
		if(left >= 0){
			return left;
		}
		
		return binarySearch(A, Math.max(middle + 1,A[middle]), end);
 					
	}
	
	
	public static void main(String [] args){
		int a[] = new int [10];
		
		for(int i = 0; i < a.length; i++){
			a[i] = -3 + 2 * i;
		}
		
		System.out.println(magicIndex(a));

	}
	
}
