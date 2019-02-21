package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution40 {

    Solution40 solution40;

    @BeforeEach
    void setUp() {
        solution40 = new Solution40();
    }

    @Test
    public void test(){

        /**
         *   [Given input matrix =
         * [
         *   [1,2,3],
         *   [4,5,6],
         *   [7,8,9]
         * ],
         *
         * rotate the input matrix in-place such that it becomes:
         * [
         *   [7,4,1],
         *   [8,5,2],
         *   [9,6,3]
         * ]
         */

        int inputs[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int expected[][] = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        int results[][] = solution40.rotate(inputs);
        int i = 0;
        for (int[] innerArray : results) {
            assertArrayEquals(expected[i++], innerArray);
        }
    }

    @Test
    public void test2(){

        /**
         *   Given input matrix =
         * [
         *   [ 5, 1, 9,11],
         *   [ 2, 4, 8,10],
         *   [13, 3, 6, 7],
         *   [15,14,12,16]
         * ],
         *
         * rotate the input matrix in-place such that it becomes:
         * [
         *   [15,13, 2, 5],
         *   [14, 3, 4, 1],
         *   [12, 6, 8, 9],
         *   [16, 7,10,11]
         * ]
         */

        int inputs[][] = new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        int expected[][] = new int[][]{{15,13, 2, 5},{14, 3, 4, 1},{12, 6, 8, 9},{16, 7,10,11}};
        int results[][] = solution40.rotate(inputs);
        int i = 0;
        for (int[] innerArray : results) {
            assertArrayEquals(expected[i++], innerArray);
        }
    }


}