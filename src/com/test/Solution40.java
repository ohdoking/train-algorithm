package com.test;

/**
 * Rotate Image
 *
 * @author ohdoking
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
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
 *
 * I'm gonna walk through to solve this problem.
 *
 * 1,1 -> 1,3
 * 1,2 -> 2,3
 * 1,3 -> 3,3
 *
 * 2,1 -> 1,2
 * 2,2 -> 2,2
 * 2,3 -> 3,2
 *
 * 3,1 -> 1,1
 * 3,2 -> 2,1
 * 3,3 -> 3,1
 *
 *
 * other solution
 *
 * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
 *
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * after transpose, it will be swap(matrix[i][j], matrix[j][i])
 *
 * 1  4  7
 * 2  5  8
 * 3  6  9
 *
 * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
 *
 * 7  4  1
 * 8  5  2
 * 9  6  3
 *
 * public void rotate(int[][] matrix) {
 *         for(int i = 0; i<matrix.length; i++){
 *             for(int j = i; j<matrix[0].length; j++){
 *                 int temp = 0;
 *                 temp = matrix[i][j];
 *                 matrix[i][j] = matrix[j][i];
 *                 matrix[j][i] = temp;
 *             }
 *         }
 *         for(int i =0 ; i<matrix.length; i++){
 *             for(int j = 0; j<matrix.length/2; j++){
 *                 int temp = 0;
 *                 temp = matrix[i][j];
 *                 matrix[i][j] = matrix[i][matrix.length-1-j];
 *                 matrix[i][matrix.length-1-j] = temp;
 *             }
 *         }
 *     }
 *
 */
class Solution40 {
    public int[][] rotate(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0){
            return null;
        }

        int[] tempArray = new int[matrix.length * matrix.length];

        int index = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix.length ; j++){
                tempArray[index++] = matrix[i][j];
            }
        }

        index = 0;
        for(int i = matrix.length - 1 ; i >= 0; i--){
            for(int j = 0 ; j < matrix.length ; j++){
                matrix[j][i] = tempArray[index++];
            }
        }

        return matrix;

    }
}