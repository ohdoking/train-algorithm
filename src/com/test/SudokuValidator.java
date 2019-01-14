package com.test;

import java.util.Arrays;

/**
 * 
 * @author ohdoking
 * 
 *         Sudoku Solution Validator
 * 
 *         Sudoku Solution Validator Write a function
 *         validSolution/ValidateSolution/valid_solution() that accepts a 2D
 *         array representing a Sudoku board, and returns true if it is a valid
 *         solution, or false otherwise. The cells of the sudoku board may also
 *         contain 0's, which will represent empty cells. Boards containing one
 *         or more zeroes are considered to be invalid solutions.
 * 
 *         The board is always 9 cells by 9 cells, and every cell only contains
 *         integers from 0 to 9.
 * 
 *         Examples 
 *         
 *         validSolution([
 *				 		  [5, 3, 4, 6, 7, 8, 9, 1, 2],
 *				 		  [6, 7, 2, 1, 9, 5, 3, 4, 8],
 *				 		  [1, 9, 8, 3, 4, 2, 5, 6, 7],
 *				 		  [8, 5, 9, 7, 6, 1, 4, 2, 3],
 *				 		  [4, 2, 6, 8, 5, 3, 7, 9, 1],
 *				 		  [7, 1, 3, 9, 2, 4, 8, 5, 6],
 *				 		  [9, 6, 1, 5, 3, 7, 2, 8, 4],
 *				 		  [2, 8, 7, 4, 1, 9, 6, 3, 5],
 *				 		  [3, 4, 5, 2, 8, 6, 1, 7, 9]
 *				 		]); // => true
 *
 *			validSolution([
 *				 		  [5, 3, 4, 6, 7, 8, 9, 1, 2], 
 *				 		  [6, 7, 2, 1, 9, 0, 3, 4, 8],
 *				 		  [1, 0, 0, 3, 4, 2, 5, 6, 0],
 *				 		  [8, 5, 9, 7, 6, 1, 0, 2, 0],
 *				 		  [4, 2, 6, 8, 5, 3, 7, 9, 1],
 *				 		  [7, 1, 3, 9, 2, 4, 8, 5, 6],
 *				 		  [9, 0, 1, 5, 3, 7, 2, 1, 4],
 *				 		  [2, 8, 7, 4, 1, 9, 6, 3, 5],
 *				 		  [3, 0, 0, 4, 8, 1, 1, 7, 9]
 *				 		]); // => false
 *				 		
 *
 * 
 */
//TODO 리펙토링이 절실 
public class SudokuValidator {
	public static boolean check(int[][] sudoku) {
		
		if(!isCorrectSudoku(sudoku)) {
			return false;
		}
		
		sudoku = swap2DimensionalArray(sudoku);
		
		if(!isCorrectSudoku(sudoku)) {
			return false;
		}
		
		return true;
		
	}
	
	private static int[][] swap2DimensionalArray(int[][] sudoku) {
		for(int i = 0 ; i < sudoku.length ; i++) {
			for(int j = i ; j < sudoku[i].length ; j++) {
				if(i == j) {
					continue;
				}
				int temp = sudoku[i][j];
				sudoku[i][j] = sudoku[j][i];
				sudoku[j][i] = temp;
			}
		}
		return sudoku;
	}
	
	private static boolean isCorrectSudoku(int[][] sudoku) {
		// first line sum is all same sum
		int sum = Arrays.stream(sudoku[0]).distinct().sum();
		
		// check line
		for(int i = 0 ; i < sudoku.length ; i++) {
			//0 is empty, so i remove the 0 for counting
			int[] unique = Arrays.stream(sudoku[i]).filter(x->x!=0).distinct().toArray();
			if(unique.length != sudoku[i].length) {
				return false;
			}
		}
		
		//TODO 모두를 만족하지 못함! 그리고 체이닝으로 해보자 
		//check 3X3 sum
		for(int i = 1 ; i <= 3; i++) {
			if(sum3X3(i, sudoku) != sum) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int sum3X3(int count, int[][] sudoku) {
		int sum = 0;
		int last = count * 3;
		int start = last - 3;
		for(int i = start ; i < last; i++) {
			for(int j = start ; j < last; j++) {
				 sum += sudoku[i][j];
			}
		}
		return sum;
	}
}