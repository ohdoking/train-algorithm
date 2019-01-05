package com.test;


class Solution9 {
    public String solution(int A, int B) {
        // write your code in Java SE 8
    	
    	//A > 2B + 2
    	String result = "";
    	
        int difference = A-B; 
       
    	// 2+1 3 개씩 끊어서 생각 
    	if(difference == 0) {
    		for(int i = 0 ; i < A ; i++) {
    			result = result.concat("a");
    			result = result.concat("b");
    		}
    	}
    	else {
    		if(difference > 0) {
    			result = makeString(A,B,true);
    		}
    		else if(difference < 0) {
    			result = makeString(B,A,false);
    		}
    	}
        
        return result;
    }
    
    /**
     * 
     * makeContinuousString 
     * 
     * @param bv Big Value
     * @param sv Small Value
     * @param isA A is big or not
     * @return
     */
    private String makeString(int bv, int sv, boolean isA) {
    	String result = "";
    	boolean state = true;
    	
    	String bigString = isA ? "a" : "b";
		String smallString = !isA ? "a" : "b";
    	
    	while(state) {
			if(bv+sv < 3) {
				for(int i = 0 ; i < bv ; i++) {
					result = result.concat(bigString);
					for(int j = 0 ; j < sv ; j++) {
						result = result.concat(smallString);
					}
				}
				state = false;
			}
			else {
				result = result.concat(bigString);
				result = result.concat(bigString);
				result = result.concat(smallString);
				
				bv = bv - 2;
				sv = sv - 1;
			}
		}
    	
    	return result;
    }
}