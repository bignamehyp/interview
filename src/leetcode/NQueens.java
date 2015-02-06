package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	
	
	public int totalNQueens(int n) {
		return solveNQueens(n).size();
	}

	
	
	 public ArrayList<String[]> solveNQueens(int n) {
		 ArrayList<String[]> ans = new ArrayList<String[]>();
		 findConfig(ans, new int [n], 0, n);
 		 return ans;
	 }
	 
	 void findConfig( ArrayList<String[]> ans, int [] path ,int pos, int n){
		 if(pos == n){
			 String [] board = new String [n];
			 for(int i = 0; i < n; i++){
				char [] row = new char[n];
				Arrays.fill(row, '.');
				row[path[i]] = 'Q';
				board[i] = new String(row);
			 }
			 ans.add(board);
		 }
		 boolean [] removed = new boolean[n];
		 for(int i = 0; i < pos; i ++){
			 int j = path[i];
			 removed[j] = true;
			 if(j + i - pos >= 0)
				 removed[j + i - pos] = true;
			 if(j - i  + pos < n)
				 removed[j - i + pos] = true;
		 }
		 
		 for(int l = 0; l < n; l++){
			 if(removed[l] == false){
				 path[pos] = l;
				 findConfig(ans, path, pos+1, n);
			 }
		 }
	 }
	 
}
