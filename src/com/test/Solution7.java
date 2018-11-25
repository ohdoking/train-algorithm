package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ohdoking
 *
 */
class Solution7 {
    public int solution(int[] A, int[] B, int[] C) {
    	
    	//already used plank List
    	List<Integer> putPlankList = new ArrayList<Integer>();
    	int count = 0;
    	for(int j = 0 ; j < C.length ; j++) {
    		for(int i = 0 ; i < A.length; i++) {
				if(!putPlankList.contains(i) && canNailed(A[i], B[i], C[j]) ) {
					putPlankList.add(i);
				}
				// if you use all nail,  
    		}
    		if(putPlankList.size() == A.length) {
    			count = j+1;
    			break;
    		}
    	}
    	
    	//If it is not possible to nail all the planks, the function should return −1
    	//putPlankList.size() == A.length is fail
    	return putPlankList.size() == A.length ? count : -1;
    	
    }
    
    /**
     * 
     * @param start
     * @param end
     * @param np nail position
     * @return
     */
    private boolean canNailed(int start, int end, int np){
    	
    	return np >= start && np <= end; 
    	
    }
}