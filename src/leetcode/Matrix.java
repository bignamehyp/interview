package leetcode;

import java.util.LinkedList;

public class Matrix {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int NX = matrix.length;
		int NY = matrix[0].length;

		int [] hist;


		int max = 0;

		hist = new int[NY + 1];

		
		for(int x = 0; x < NX; x++){
		  
					
			for(int y = 0; y < NY; y++){
				if(matrix[x][y] == '1'){
					hist[y]++;
				}else{
					hist[y] = 0;
				};
 			}

			hist[NY] = 0;

			LinkedList<Integer> incBoundary = new LinkedList<Integer>();

			for(int i = 0; i < hist.length; i++){
				if( incBoundary.size() == 0 || hist[i] > hist[incBoundary.peekLast()]){
					incBoundary.add(i);        		
				}else{
					int h = hist[incBoundary.pollLast()];
					int area = h * ( (incBoundary.size() == 0)? i : (i - 1 - incBoundary.peekLast())  );
					if(area > max){
						max = area;
					}
					i--;
				}
			}

		}
		return max;

	}


	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}

		//search which row
		int NX = matrix.length;
		int NY = matrix[0].length;
		int l = 0, r = NX - 1;
		//find the greatest value that is less than target
		while( l <= r){
			int mid = l + (r- l)/2;
			if(target  < matrix[mid][NY - 1] ){
				if(mid == 0){
					l = 0;
					break;
				}else{
					if(target <= matrix[mid - 1][NY - 1])
						r = mid - 1;
					else{
						l = mid;
						break;
					}
				}
			}else if(target > matrix[mid][NY - 1]){
				if(mid == NX - 1){
					return false;
				}else{
					if(target > matrix[mid+1][NY - 1]){
						l = mid +1;
					}else{
						l = mid + 1;
						break;
					}
				}

			}else{
				return true;
			}
		}

		int row = l;
		l = 0; r = NY - 1;
		while(l <= r){
			int mid = l + (r- l)/2;
			if(target < matrix[row][mid]){
				r = mid - 1;
			}else if(target > matrix[row][mid]){
				l = mid + 1;
			}else{
				return true;
			}
		}
		return false;		

	}
	

	public void setZeroes(int[][] matrix) {
		if(matrix == null)
			return;
		
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		boolean firstRow = false, firstCol = false;
		
		for(int row = 0; row < numRow; row++){
			if(matrix[row][0] == 0){
				firstCol = true;
				break;
			}
		}
		
		for(int col = 0; col < numCol; col++){
			if(matrix[0][col] == 0){
				firstRow = true;
				break;
			}
		}
		
		for(int row = 1; row < numRow; row++){
			for(int col = 1; col < numCol; col++){
				if(matrix[row][col] == 0){
					matrix[row][0] = 0;
					matrix[0][col] = 0;
				}
			}
		}
		
		for(int row = 1; row < numRow; row++){
			for(int col = 1; col < numCol; col++){
				if(matrix[row][0] == 0 ||matrix[0][col] == 0 ){
					matrix[row][col] = 0;
 				}
			}
		}
		if(firstRow){
			for(int col = 0; col < numCol; col++){
				matrix[0][col] = 0;
			}
		}
		if(firstCol){
			for(int row = 0; row < numRow; row++){
				matrix[row][0] = 0;
			}
		}
		
    }

	

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		 if(matrix == null || matrix.length <= 1 || matrix[0].length <= 1){
			 return;
		 }
		 
		 int N = matrix.length;
		 int l = 0;
		 int r = N - 1;
		 
		 while( l < r ){
			 for(int i = 0; i < r  - l; i++){
				 int tmp = matrix[r - i][l];
				 matrix[r - i][l] = matrix[r][ r -i ];
				 matrix[r][r - i] = matrix[l + i][r];
				 matrix[l + i][r] = matrix[l][l + i]; 
				 matrix[l][l + i] = tmp;						 						 
			 }
			 l++;
			 r--;
		 }
		 
	 }

}
