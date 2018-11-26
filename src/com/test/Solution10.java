package com.test;

import java.util.stream.IntStream;

/**
 * 
 * For a given integer K, 
 * the goal is to tie the ropes in such a way 
 * that the number of ropes whose length is greater than or equal to K is maximal.
 * 
 * 
 * @author ohdoking
 *
 */
class Solution10 {
	public int solution(int K, int[] A) {
        // write your code in Java SE 8
		
		//AtomicInteger count = new AtomicInteger(0);
		
		int count = 0;
		int[] standardIndexArray = IntStream
			.range(0, A.length)
			.filter(idx -> A[idx] >= K)
			.toArray();
		
		for(int i = 0 ; i <= standardIndexArray.length; i++) {
			
			int start = i == 0 ? 0 : standardIndexArray[i-1] + 1;
			int end = standardIndexArray.length == i ? A.length : standardIndexArray[i];
			
			int tempResult = 0;
			for(int j = start ; j < end ; j++){
				tempResult = tempResult+A[j];
				if(tempResult >= K) {
					count++;
					tempResult = 0;
				}
			}	
			//@ fix random value exception .
			//count += tempResult / K;
			
		}
		
		return count + standardIndexArray.length;
    }
}