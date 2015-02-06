package crack150;

public class Problem11_5 {
	public static  int search(String[] array, String item){
		if(array == null)
			return -1;
		return search(array, item, 0, array.length - 1);
	}
	
	public static  int search(String[] array, String item, int begin, int end){
		if(begin > end)
			return -1;
		int middle = begin + (end - begin) / 2;
		
		
		
		if(array[middle].isEmpty()){
			int left = middle - 1;
			int right = middle + 1;
			while(true){
				if(left < begin && right > end)
					return -1;
				else if(right <= end && !array[right].isEmpty()){
					middle = right;
					break;
				}if(left >= begin && !array[left].isEmpty()){
					middle = left;
					break;
				}
				left--;
				right++;
			}
		}
		
		if(array[middle].compareTo(item) == 0)
			return middle;
		if(array[middle].compareTo(item) > 0){
			return search(array, item, begin, middle - 1);
		}else{
			return search(array, item, middle + 1, end);
		}
		
	}
}
