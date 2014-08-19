package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class SurroundedRegions {
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0)
			return;
		int numRows =  board.length;
		int numCols = board[0].length;
		
		if(numRows <= 2 || numCols <= 2)
		    return;
		
 		 
		for(int col = 0; col < numCols; col++){
			if(board[0][col] == 'O'){
 				bfs(0, col, numRows, numCols, board);
			}
		}
		for(int row = 1; row < numRows; row++){
			if(board[row][numCols - 1] == 'O'){
 				bfs(row, numCols - 1, numRows, numCols, board);
			}
		}
		
		for(int col = 0; col < numCols - 1; col++){
			if(board[numRows - 1][col] == 'O'){
 				bfs(numRows - 1, col, numRows, numCols, board);
			}
		}
		
		for(int row = 1; row < numRows - 1; row++){
			if(board[row][0] == 'O'){
 				bfs(row, 0, numRows, numCols, board);
			}
		}
		
		for(int row = 1; row < numRows - 1; row++){
			for(int col = 1; col < numCols - 1; col++){
				if(board[row][col] == 'O')
					board[row][col] = 'X';
				if(board[row][col] == 'Y')
					board[row][col] = 'O';
			}
		}
     }
	
	void bfs( int row, int col,int numRows, int numCols, char [][] board){
		boolean [][] visited = new boolean[numRows][numCols];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(row * numCols + col);
		visited[row][col] = true;
		while(queue.size() > 0){
			int idx1D = queue.removeFirst();
			int parent_c = idx1D % numCols;
			int parent_r = (idx1D - parent_c ) /numCols;
			ArrayList<Integer> children = getChildren(parent_r, parent_c, numRows, numCols, board);
			for(int child : children){
				int child_c = child % numCols;
				int child_r = (child - child_c)/numCols;
				if(visited[child_r][child_c] == false){
					board[child_r][child_c] = 'Y';
					queue.add(child);
					visited[child_r][child_c] = true;
				}
			}
		}
	}
	
	ArrayList<Integer> getChildren(int r, int c, int numRows, int numCols, char [][] board){
		ArrayList<Integer> children = new ArrayList<Integer>();
		if( r + 1 < numRows - 1 && c!= 0 && c != numCols -1 && board[r+1][c] == 'O'){
			children.add( ( r + 1) * numCols + c); 
		}
		if( r - 1 >  0 && c!= 0 && c != numCols -1  && board[r - 1][c] == 'O'){
			children.add( ( r - 1) * numCols + c); 
		}
		if( c + 1 < numCols - 1 && r != 0 && r != numRows - 1 && board[r][c+1] == 'O'){
			children.add( r * numCols + c + 1); 
		}
		if( c  - 1  >  0 && r != 0 && r != numRows - 1 && board[r][c-1] == 'O'){
			children.add( r * numCols + c - 1); 
		}
		return children;
	}
	
	public static void main(String [] args){
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = new char[3][3];
		for(int r = 0; r < board.length; r++)
			for(int c = 0; c < board[0].length; c++)
				board[r][c] = 'X';
 		board[1][1] = 'O';
		s.solve(board);
	}
	  
}
