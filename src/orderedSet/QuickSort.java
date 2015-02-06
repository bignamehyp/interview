package orderedSet;


public class QuickSort {
	public static int cutoff = 10;
	
	public static void sort(Comparable [] a){
		_quickSort(a, 0, a.length - 1);
	}
	/**
	 * @param a  input array
	 * @param option = 2 use three ways division quicksort, when a contains many duplications
	 */
	public static void sort(Comparable [] a, int option){
		if(option == 2){
			_quickSort2(a, 0, a.length - 1);
		}
	}
	
	private static final int _parition(Comparable [] a, int left, int right){
		int i = (left +right)/2;
		/*Median of three*/
		if( a[ i ].less( a[ left ] ) )
			_swap( a, left, i );
        if( a[ right ].less( a[ left ] ))
        	_swap( a, left, right );
        if( a[ right ].less( a[ i ] )  )
        	_swap( a, i, right);
        
		Comparable tmp = a[i];
		_swap(a, i, right - 1); //place pivot at position right - 1
		
		i = left;
		int j = right - 1;
		for(;;){
			while(a[++i].less(tmp));
			while(tmp.less(a[--j]));
			if(i < j){
				_swap(a,i,j);
			}
			else
				break;
		}
		_swap(a,i,right - 1);
		return i;
	}
	

	
	private static void _quickSort(Comparable [] a, int left, int right){
		if(right < left + cutoff){
			InsertionSort.sort(a,left,right);
			return;
		}
		int index = _parition(a, left, right);
		if(index -1 > left)
			_quickSort(a, left, index - 1);
		if(index + 1 < right)
			_quickSort(a, index + 1, right);
	}
	
	/**
	 * Three ways division, used when there are many duplicated values in a 
	 * @param a: array to be sorted
	 * @param left left boundary
	 * @param right right boundary
	 */
	
	private static void _quickSort2(Comparable [] a, int left, int right){
		if(right <= left)
			return;
		Comparable v = a[right];
		int i = left - 1;
		int j = right;
		int p = left - 1;
		int q = right;
		for(;;){
			while(a[++i].less(v));
			while(v.less(a[--j]))
				if(j == left)break;
			if(i >= j)break;
			_swap(a,i,j);
			if(a[i].equals(v)){
				p++;
				_swap(a,p,i);
			}
			if(v.equals(a[j])){
				q--;
				_swap(a,q,j);
			}
		}
		_swap(a,i,right);
		j = i- 1;
		i++;
		for(int k = left; k < p; k++,j--)
			_swap(a,k,j);
		for(int k = right - 1; k > q; k--, i++)
			_swap(a,k,i);
		
		_quickSort2(a,left,j);
		_quickSort2(a,i,right);
	}
	
	private static final void _swap(Comparable [] a, int i, int j){
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	
}
