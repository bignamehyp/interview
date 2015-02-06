package crack150;

public class Problem9_5 {
	public static void printAllPermutation(String s){
		printAllPermutation( s.toCharArray(), 0);
	}
	
	static void printAllPermutation(char [] a, int index){
	
		if(index == a.length - 1){
			for(int i = 0; i < a.length; i++)
				System.out.print(a[i]);
			System.out.println();
			return;
		}
		
		printAllPermutation(a, index + 1);
			
		char c = a[index];
		
		for(int i = index + 1; i < a.length; i++){
			a[index] = a[i];
			a[i] = c;
			printAllPermutation(a, index + 1);
			a[i] = a[index];
			a[index] = c;
		}
		
		
	}
	
	
	public static void main(String [] args){
		String s = "abcd";
		
		printAllPermutation(s);
	}

}
