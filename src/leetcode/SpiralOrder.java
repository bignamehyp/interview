package leetcode;

import java.util.ArrayList;

public class SpiralOrder {


	//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	public int[][] generateMatrix(int n) {
		int [][] a = new int [n][n];
		int i = 1;
		int rowLeft = 0;
		int colUp = 0;
		int colDown = n - 1 ;
		int rowRight = n- 1;

		while(rowLeft <= rowRight && colUp <= colDown){

			for(int row = rowLeft; row <= rowRight; row++){
				a[colUp][row] = i;
				i++;
			}

			for(int col = colUp + 1; col <= colDown; col++){
				a[col][rowRight] = i;
				i++;
			}

			if(colDown > colUp){
				for(int row = rowRight - 1; row >= rowLeft; row--){
					a[colDown][row] = i;			 
					i++;
				}
			}

			if(rowLeft < rowRight){
				for(int col = colDown - 1; col >= colUp + 1; col--){
					a[col][rowLeft] = i;
					i++;
				}
			}


			rowLeft++;
			colUp++;
			rowRight--;
			colDown--;
		}
		return a;
	}


	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return new ArrayList<Integer>();
		int rowLeft = 0;
		int colUp = 0;
		int colDown = matrix.length - 1 ;
		int rowRight = matrix[0].length - 1;

		ArrayList<Integer> output = new  ArrayList<Integer>();
		while(rowLeft <= rowRight && colUp <= colDown){
			output.addAll(getP(matrix, rowLeft, rowRight, colUp, colDown));
			rowLeft++;
			colUp++;
			rowRight--;
			colDown--;
		}
		return output;
	}

	public ArrayList<Integer> getP(int[][] matrix, int rowLeft, int rowRight, int colUp, int colDown){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int row = rowLeft; row <= rowRight; row++){
			output.add(matrix[colUp][row]);
		}

		for(int col = colUp + 1; col <= colDown; col++){
			output.add(matrix[col][rowRight]);
		}

		if(colDown > colUp){
			for(int row = rowRight - 1; row >= rowLeft; row--){
				output.add(matrix[colDown][row]);			 
			}
		}

		if(rowLeft < rowRight){
			for(int col = colDown - 1; col >= colUp + 1; col--){
				output.add(matrix[col][rowLeft]);			 
			}
		}

		return output;
	}
}
