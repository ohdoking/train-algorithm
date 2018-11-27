package com.test;

/**
 * 
 * MaxDoubleSliceSum
 * 
 * 	A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * 	The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * 	The goal is to find the maximal sum of any double slice.
 * 
 * @author ohdoking
 *
 */
class Solution11 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	int maxEnding = 0;
    	int maxSlice = 0;
    	int minValue = Integer.MAX_VALUE;
    	
    	int sum = 0;
    	int result = 0;
    	for(int i = 1 ; i < A.length-1 ; i++) {
    		sum = 0;
    		for(int j = i ; j < A.length-1 ; j++) {
    			sum += A[j];
    			//minValue = minValue > A[i] ? A[i] : minValue;
    			result = Math.max(result, sum);
    		}
    	}
    	/*for(int i = 1 ; i < A.length - 1 ; i++) {
    		maxEnding = Math.max(0, maxEnding + A[i]);
    		minValue = minValue > A[i] ? A[i] : minValue;
     		maxSlice = Math.max(maxSlice, maxEnding);
    	}
    	
    	
		return maxSlice + minValue ;*/
    	return result;
    }
}