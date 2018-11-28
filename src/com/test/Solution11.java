package com.test;

/**
 * 
 * MaxDoubleSliceSum
 * 
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... +
 * A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1]. The goal is to find the
 * maximal sum of any double slice.
 * 
 * @author ohdoking
 *
 */
class Solution11 {
	public int solution(int[] A) {
		int arrLength = A.length;
		int[] tempArr = new int[arrLength];
		int[] backTempArr = new int[arrLength];
		int max = 0;

		// define tempArr[i] as the maximum sum contiguous subsequence ending at index  i
		for (int i = 1; i < arrLength - 1; i++) {
			tempArr[i] = Math.max(tempArr[i - 1] + A[i], 0);
		}
		
		//backTempArr[i] as the maximum sum contiguous subsequence starting with index i.
		for (int i = arrLength - 2; i > 0; i--) {
			backTempArr[i] = Math.max(backTempArr[i + 1] + A[i], 0);
		}

		// iterate over i, and find the maximum sum of K1[i-1]+K2[i+1]. 
		for (int i = 1; i < arrLength - 1; i++) {
			max = Math.max(max, tempArr[i - 1] + backTempArr[i + 1]);
		}

		return max;
	}
}