package crack150;

public class Problem11_3 {
	public static <E extends Comparable<? super E>> int search( E[] array, E item){
		if(array == null)
			return -1;
		return search(array, item, 0, array.length - 1);
		
	}
	static <E extends Comparable<? super E>> int search( E[] array, E item, int begin, int end){
		if(end < begin)
			return -1;
 		int middle = begin + (end - begin ) / 2;
		if(array[middle].compareTo(item) == 0){
			return middle;
		}
			
		if(array[middle].compareTo(item) > 0){
			if( array[end].compareTo(array[middle]) > 0){
				return search(array, item, begin, middle - 1);
			}else{
				int result = search(array, item, begin, middle - 1);
				if(result >= 0)
					return result;
				return search(array, item, middle + 1, end);
			}
		}else{
			if( array[end].compareTo(array[middle]) > 0){
				return search(array, item, middle + 1, end);				
			}else{
				int result = search(array, item, middle + 1, end);
				if(result >= 0 )
					return result;
				return search(array, item, begin, middle - 1);
			}
		}
		 
	}
	
	public static void main(String[] args){
		String [] str = new String[]{"c","c","c", "a", "b", "c"};
		System.out.println(search(str, "a"));
	}
}
