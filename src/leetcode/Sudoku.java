package leetcode;

public class Sudoku {


	public boolean isValidSudoku(char[][] board) {
		boolean [][] rows = new boolean [9][9];
		boolean [][] cols = new boolean [9][9];
		boolean [][] sqres = new boolean [9][9];

		for(int sq1 = 0; sq1 < 3; sq1++){
			for(int sq2= 0; sq2 < 3; sq2++){
				int sqrNumber = sq1 * 3 + sq2;
				for(int i = sq1 * 3; i < sq1 * 3 + 3; i++){
					for(int j = sq2 * 3; j < sq2 * 3 + 3 ;j++){
						int digit = board[i][j] - '1';
						if(digit <  0 || digit > 8)
							continue;
						if(rows[i][digit]){
							return false;
						}else{
							rows[i][digit] = true;
						}
						if(cols[j][digit]){
							return false;
						}else{
							cols[j][digit] = true;
						}if(sqres[sqrNumber][digit]){
							return false;
						}else{
							sqres[sqrNumber][digit] = true;
						}

					}
				}

			}
		}
		return true;

	}

	public void solveSudoku(char[][] board) {
		boolean [][] rows = new boolean [9][9];
		boolean [][] cols = new boolean [9][9];
		boolean [][] sqres = new boolean [9][9];
		//char[][] board2 = new char[9][9];
		for(int sq1 = 0; sq1 < 3; sq1++){
			for(int sq2= 0; sq2 < 3; sq2++){
				int sqrNumber = sq1 * 3 + sq2;
				for(int i = sq1 * 3; i < sq1 * 3 + 3; i++){
					for(int j = sq2 * 3; j < sq2 * 3 + 3 ;j++){
						//board2[i][j] = board[i][j];
						int digit = board[i][j] - '1';
						if(digit <  0 || digit > 8)
							continue;
						rows[i][digit] = true;
						cols[j][digit] = true;
						sqres[sqrNumber][digit] = true;
					}
				}
			}
		}

		solveSudoku(board, 0,0, rows, cols, sqres); 		

	}


	boolean solveSudoku(char[][] board,   int i, int j, boolean [][] rows, boolean [][] cols, boolean [][] sqres){
		int sq1 = i / 3;
		int sq2 = j / 3;
		int sq = sq1 * 3 + sq2;
		int i2, j2;
		if(j < 8){
			i2 = i;
			j2 = j + 1;
		}else{
			i2 = i +  1;
			j2 = 0;
		}

		//the end
		if(i == 8 && j == 8){
			//			for(int k = 0; k < 9; k++)
			//				for(int k2 = 0; k2 < 9; k2++)
			//					board[k][k2] = board2[k][k2];
			return true;
		}

		if(board[i][j] != '.'){
			return solveSudoku(board, i2,j2, rows, cols, sqres); 		
		}

		for(int n = 0; n < 9; n++){				
			if(rows[i][n] == false && cols[j][n] == false && sqres[sq][n] == false){
				//try n
				board[i][j] = (char) (n + '1');
				rows[i][n] = true;
				cols[j][n] = true;
				sqres[sq][n] = true;
				if (solveSudoku(board, i2,j2, rows, cols, sqres) == false){
					sqres[sq][n] = false;
					cols[j][n] = false;
					rows[i][n] =false;
					board[i][j] = '.';
				}else
				    return true;
			}				
		}
		return false;
	}




}
