package com.test;
class Solution4 {
	public static int solution(int[] A) {
		
	    long leftSum;
	    long rightSum;
	    long totalSum=0;
	        
	    int last_minimum=100000;
	    long current_min;
	    
	    if(A.length==2) return Math.abs(A[0]-A[1]);
	    if(A.length==1) return Math.abs(A[0]);
	    
	    for(int index=0; index < A.length; index++)
	        totalSum = totalSum + A[index];
	        
	    leftSum = 0; rightSum = 0;
	        
	    for (int p = 1; p <= A.length-1; p++) {
	        
	        leftSum += A[p - 1];
	        rightSum = totalSum - leftSum;        
	        
	        current_min = Math.abs((long)(leftSum - rightSum));
	               
	        last_minimum = (int) (current_min < last_minimum ? current_min : last_minimum);
	        if (last_minimum == 0)
	            break;    
	    }
	    return last_minimum;
	}

}