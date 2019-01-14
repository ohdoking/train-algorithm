package com.test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SudokuValidatorTest {
	
    @Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        //assertEquals(true, SudokuValidator.check(sudoku));

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

        //assertEquals(false, SudokuValidator.check(sudoku));   
        
        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;
        
        sudoku[4][4] = 0;

        assertEquals(false, SudokuValidator.check(sudoku));
    }
    
    @Test
    public void moreRandomTest() {
    	int[][] sudoku = {
    			{1, 2, 3, 4, 5, 6, 7, 8, 9},
    			{2, 3, 1, 5, 6, 4, 8, 9, 7},
    			{3, 1, 2, 6, 4, 5, 9, 7, 8},
    			{4, 5, 6, 7, 8, 9, 1, 2, 3},
    			{5, 6, 4, 8, 9, 7, 2, 3, 1},
    			{6, 4, 5, 9, 7, 8, 3, 1, 2},
    			{7, 8, 9, 1, 2, 3, 4, 5, 6},
    			{8, 9, 7, 2, 3, 1, 5, 6, 4},
    			{9, 7, 8, 3, 1, 2, 6, 4, 5}
    	};
    	
    	assertEquals(false, SudokuValidator.check(sudoku));
    }
    
    
}