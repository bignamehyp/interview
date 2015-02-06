package crack150;

public class Problem9_6 {
	
		public static void printALlPairs(int n){
			int [] accuRight = new int [n + 1];
			accuRight[0] = 0;
			printAllPairs(accuRight, 1,  n);
				 
		}
		
		static void printAllPairs(int[] accuRight, int index, int n){
		
			if(index <= 0)
				return;
			
			if(index == n){
				
				accuRight[n] = n;
						
				for(int leftIndex = 1; leftIndex <= n; leftIndex++){
					System.out.print('(');
					for(int rightIndex = accuRight[leftIndex - 1] + 1; rightIndex <= accuRight[leftIndex]; rightIndex++)
						System.out.print(')');
				}
				System.out.println();
				return;
			}
			
 				
			for(int numRights = accuRight[index -1 ]; numRights <= index; numRights++){
				accuRight[index] = numRights;
				printAllPairs(accuRight, index + 1, n);
			}
		 
			
		}
		
		
		public static void main(String [] args){
 			
			printALlPairs(3);
		}
}
