package crack150;

public class Problem11_6 {
	public static <E extends Comparable<? super E>> boolean search( E[][] array,  E item){
		int row = 0;
		int col = array[0].length - 1;
		
		while(row < array.length && col >= 0){
			if(array[row][col].equals(item)){
				return true;
			}else if(array[row][col].compareTo(item) > 0){
				col--;
			}else 
				row++;
		}
		return false;
	}
}
