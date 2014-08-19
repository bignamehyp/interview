package orderedSet;

import java.util.Random;


public class QuickSortFloat {
		public static int cutoff = 5;
		
		public static void sort(float [] a){
			_quickSort(a, 0, a.length - 1);
		}
		/**
		 * @param a  input array
		 * @param option = 2 use three ways division quicksort, when a contains many duplications
		 */
		public static void sort(float [] a, int option){
			if(option == 2){
				_quickSort2(a, 0, a.length - 1);
			}
		}
		
		private static final int _parition(float [] a, int left, int right){
			int i = (left +right)/2;
			/*Median of three*/
			if( a[ i ] <  a[ left ]  )
				_swap( a, left, i );
	        if( a[ right ] <  a[ left ] )
	        	_swap( a, left, right );
	        if( a[ right ] <  a[ i ]   )
	        	_swap( a, i, right);
	        
			float tmp = a[i];
			_swap(a, i, right - 1); //place pivot at position right - 1
			
			i = left;
			int j = right - 1;
			for(;;){
				while(a[++i] < tmp);
				while(tmp < a[--j]);
				if(i < j){
					_swap(a,i,j);
				}
				else
					break;
			}
			_swap(a,i,right - 1);
			return i;
		}
		

		
		private static void _quickSort(float [] a, int left, int right){
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
		
		private static void _quickSort2(float [] a, int left, int right){
			if(right <= left)
				return;
			float v = a[right];
			int i = left - 1;
			int j = right;
			int p = left - 1;
			int q = right;
			for(;;){
				while(a[++i] < v);
				while(v < a[--j])
					if(j == left)break;
				if(i >= j)break;
				_swap(a,i,j);
				if(a[i] == v){
					p++;
					_swap(a,p,i);
				}
				if(v == a[j]){
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
		
		private static final void _swap(float [] a, int i, int j){
			float tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		
		
		
		public static void main(String[] args){
			int n = 20;
			
			if(args.length >= 1){
				n = Integer.valueOf(args[0]);
			}			
			
			for(int iter  = 0; iter < 20; iter++){
				float [] a = new float[n];  	
		    	Random generator = new Random();
		    	
		    	for(int i = 0; i < n; i++)
		    		a[i] = generator.nextFloat();
		    	//long start = System.currentTimeMillis();
		    	sort(a);
		    	//System.out.printf("It takes %d ms to sort %d elements using quick Sort\n",System.currentTimeMillis() - start, n);
			}
			return;					
		}
		
	}


