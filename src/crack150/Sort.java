package crack150;

import java.util.ArrayList;
import java.util.Random;

 
public class Sort {
	
	
	public static <E extends Comparable<? super E>> int binarySearch( E[] array, E item){
		int begin = 0;
		int end = array.length - 1;
		
		while(begin <= end){
			int middle = begin + (end - begin)/2;

			if(array[middle].compareTo(item) == 0)
				return middle;
			if(array[middle].compareTo(item) < 0){
				end = middle - 1;				
			}else{
				begin = middle + 1;
			}
		}
		return -1;
	}

	
	
	public static <E extends Comparable<? super E>> void mergeSort( E[] array){
		ArrayList<E> helper = new ArrayList<E>();
		for(E e : array){
			helper.add(e);
		}
		mergeSort(array, helper, 0, array.length - 1);
	}
	
	static <E extends Comparable<? super E>>  void mergeSort(E [] array, ArrayList<E> helper, int begin, int end){
		int middle = begin + (end - begin)/2;
		if(end <= begin)
			return;
		mergeSort(array, helper, begin, middle);
		mergeSort(array, helper, middle + 1, end);
		merge(array, helper, begin, middle, end);
	}
	
	static <E extends Comparable<? super E>>  void merge(E [] array, ArrayList<E> helper, int begin, int middle, int end){
		for(int i = begin; i <= end; i++){
			helper.set(i, array[i]);			
		}
		int leftIter = begin;
		int rightIter = middle+1;
		int iter = begin;
		while(rightIter <= end & leftIter <= middle){
			
			if(helper.get(leftIter).compareTo(helper.get(rightIter)) <= 0){
				array[iter++]= helper.get(leftIter++);
 			}
			else{
				array[iter++] = helper.get(rightIter++);
			}
		}
		
		while(leftIter <= middle){
			array[iter++] = helper.get(leftIter++);
		}
	}
	
	
	
	
	public static <E extends Comparable<? super E>> void insertionSort(E [] array){
		insertionSort(array, 0, array.length - 1);
	}
	static <E extends Comparable<? super E>> void insertionSort(E [] array, int begin, int end){
		if(end  <= begin)
			return;
		
		for(int i = begin + 1; i <= end; i++){
			int j = i - 1;
 			while(j >= begin && array[j+1].compareTo(array[j]) < 0){
				swap(array, j + 1, j);
				j--;
			}
		}
	}
	
	public static <E extends Comparable<? super E>> void quickSort( E[] array){
		quickSort(array, 0, array.length - 1);
	}
	
	public static <E extends Comparable<? super E>> void quickSort( E[] array, int begin, int end){
		if( end - begin <= 3){		
			insertionSort(array,begin,end);
			return;
		}
		int index = partition(array, begin, end);
		if(index - 1 > begin){
			quickSort(array, begin, index - 1);
		}
		
		if(index + 1 < end){
			quickSort(array, index + 1, end);
		}
		
	}
	
	public static <E extends Comparable<? super E>> int partition( E[] array, int begin, int end){
  		
		int middle = begin + ( end - begin ) / 2;
		if(array[middle].compareTo(array[begin]) < 0){
			swap(array, begin, middle);
		}
		
		if(array[end].compareTo(array[begin]) < 0){
			swap(array, begin, end);
		}
		
		if(array[end].compareTo(array[middle]) < 0){
			swap(array, middle, end);
		}
		
		E pivot = array[middle];
		swap(array, middle, end - 1);
		
		int left = begin;
		int right = end - 1;
		
		while(true){
			while(array[++left].compareTo(pivot) < 0);
			while(pivot.compareTo(array[--right]) < 0);
			if(left < right){
				swap(array, left, right);
			}
			else
				break;
		}
		
		swap(array, left, end - 1);
		return left;
		
	}
	
	public static <E> void swap(E[] array, int i, int j){
		E tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static  <E extends Comparable<? super E>> boolean test(E [] a){
		int i = 1;
		while(i < a.length){
			if(a[i].compareTo(a[i-1]) < 0)
				return false;
			i++;
		}
		return true;
	}
	
	
	public static void main(String[] args){
		int n = 20;
		 
        for(int iter = 0; iter < 100; iter++){			
        	Integer [] a = new Integer[n];  
        	Random generator = new Random();

        	for(int i = 0; i < n; i++)
        		a[i] = generator.nextInt(n);
 
        	//long start = System.currentTimeMillis();
        	insertionSort(a);
        	//System.out.printf("It takes %d ms to sort %d elements using quick Sort\n",System.currentTimeMillis() - start, n);
        	if(!test(a)){
        		System.out.println("Error");
        		for(int i = 0; i < a.length; i++)
        			System.out.print(" " + a[i]);
        		System.out.println();
        	}
        }
		return;		
		
	}
	
}
