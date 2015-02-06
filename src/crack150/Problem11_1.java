package crack150;

public class Problem11_1 {
	
	public static <E extends Comparable<? super E>> void inplaceMerge( E[] arrayA, E[] arrayB, int lastA, int lastB){
		int lastIndex = lastA + lastB + 1;
		int iterA = lastA;
		int iterB = lastB;
		
		while(  iterA >= 0 &&  iterB >= 0){
			if(arrayA[iterA].compareTo(arrayB[iterB]) >= 0){
				arrayA[lastIndex] = arrayA[iterA];
				iterA--;
			}else{
				arrayA[lastIndex] = arrayB[iterB];
				iterB--;
			}
			lastIndex--;
		}
		
		while(iterA == 0 && iterB >= 0){
			arrayA[lastIndex--] = arrayB[iterB--];
		}
	}
}
