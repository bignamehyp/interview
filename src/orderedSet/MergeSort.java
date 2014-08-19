package orderedSet;

public class MergeSort{
	
	public static void sort(Comparable [] a){
		Comparable [] result = new Comparable[a.length];
		mergeSort(a, result, 0, a.length - 1);		
	}
	
	
	
	private static void mergeSort(Comparable [] a, Comparable [] result, int left, int right){
		if(left  < right){
			int center = (left + right)/2;
			mergeSort(a, result, left, center);
			mergeSort(a, result, center + 1, right);
			merge(a, result, left, center+1, right);			
		}
	}
	
	
	private static void merge(Comparable [] a, Comparable [] result, int left, int right, int rend){
		int lend = right -1;
		int tmp = left;
		int low = left;
		
		while(left <= lend && right <= rend){
			if (a[left].compareTo(a[right]) <= 0)
				result[tmp++] = a[left++];
			else
				result[tmp++] = a[right++];
		}
		
		while(left <= lend)
			result[tmp++] = a[left++];
		
		while(right <= rend)
			result[tmp++] = a[right++];
		
		for (int i = low; i <= rend; i++)
			a[i] = result[i];
		                                      
	}
	
}
