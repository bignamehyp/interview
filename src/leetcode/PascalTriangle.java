package leetcode;

import java.util.ArrayList;
 
public class PascalTriangle {
	    /**
	     * Given numRows, generate the first numRows of Pascal's triangle.
	     * @param numRows
	     * @return
	     */
		public ArrayList<ArrayList<Integer>> generate(int numRows) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
						
			if(numRows < 0)
				return ans;
 	 
 			for(int level = 0; level < numRows; level++){
				ArrayList<Integer> numbers = new ArrayList<Integer>();

				for(int i = 0; i <  level/2 + 1; i++){
					int n = 0;
					if(i != 0){
						  n = (level  + 1 - i ) / i *  numbers.get(numbers.size() - 1);
					}
					numbers.add(n);
 				}
				for(int i = level/2+ 1; i <= level; i++){
					numbers.add(numbers.get(level - i));
				}
				ans.add(numbers);
 			}		
			return ans;
		}
		
		/**
		 * Mind the overflow
		 * @param rowIndex
		 * @return
		 */
		public ArrayList<Integer> getRow(int rowIndex) {
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				for(int i = 0; i <  rowIndex/2 + 1; i++){
					int n = 0;
					if(i != 0){
						  n = (int) ( 0.5 + 1.0 * (rowIndex  + 1 - i ) / i * numbers.get(numbers.size() - 1));
					}
					numbers.add(n);
 				}
				for(int i = rowIndex/2+ 1; i <= rowIndex; i++){
					numbers.add(numbers.get(rowIndex - i));
				}
				return numbers;
	    }
		
}
