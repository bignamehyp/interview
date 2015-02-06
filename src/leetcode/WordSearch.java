package leetcode;

public class WordSearch {
	
	
	/**
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		
		if(word == null || word.length() == 0){
			return true;
		}

		int N_X = board.length;
		int N_Y = board[0].length;
		boolean [][] visited = new boolean[N_X][N_Y];

		for(int x = 0 ;x <  N_X; x++){
			for(int y = 0; y < N_Y; y++){
				
				if(exists(x, y, 0, board,visited, word) ){
					return true;
				}
			}
		}
		return false;
	}
	
	boolean exists(int x, int y, int loc, char[][] board, boolean [][] visited, String word){
		
		visited[x][y] = true;
		
		if(board[x][y] != word.charAt(loc)){
			return false;
		}
		
		if(loc == word.length() - 1){
 			return true;			 
		}
		
		if( x > 0 && !visited[x- 1][y] && exists(x - 1, y, loc + 1, board, visited, word)){
			return true;
		}
		
		if( y > 0 && !visited[x][y-1] && exists(x, y - 1, loc + 1, board, visited, word)){
			return true;
		}
		if( x < board.length - 1 && !visited[x + 1][y] && exists(x + 1, y, loc + 1, board, visited, word)){
			return true;
		}
		if( y < board[0].length - 1 && !visited[x][y+1] && exists(x, y + 1, loc + 1, board, visited, word)){
			return true;
		}
		
		visited[x][y] = false;
		return false;
		
	}

}
