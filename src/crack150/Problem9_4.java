package crack150;

 
public class Problem9_4 {
	public static <E> void printAllSubsets(E[] set){
		int size = set.length;
		int allSubsets = (1 << size) -1;
		if(size > 8)
			return;
		
		for(int i = 1; i <= allSubsets; i++){
			
			int bit = 0;
			
			int bitVector = i;
						
			while( bitVector > 0){
				if( (bitVector & 1) == 1){
					System.out.print(set[bit] + " ");
				}
				bitVector = bitVector >> 1;
				bit++;
			}
			System.out.println();	
		}		
	}
	
	
	public static void main(String [] args){
		Integer a[] = new Integer [3];
		
		for(int i = 0; i < a.length; i++){
			a[i] = 1 +  i;
		}
		
		printAllSubsets(a);

	}
	
}
