package com.test;

class Solution1 {
    public int solution(int N) {
        // write your code in Java SE 8
        
    	String[] binaryStringArray = (Integer.toBinaryString(N)).split("");
    	int highestCount = 0;
    	int tempHighestCount = 0;
    	boolean countState = false;
    	
    	for(int i = 0 ; i < binaryStringArray.length ; i++) {
    		
    		
    		if(binaryStringArray[i].equals("1")) {
    			countState = !countState;
    		}
    		if(!countState) {
    			if(tempHighestCount > highestCount) {
    				highestCount = tempHighestCount;
    			}
    			tempHighestCount = 0;
    			countState = !countState;
    		}
    		else if(countState && binaryStringArray[i].equals("0")) {
    			tempHighestCount = tempHighestCount+1;
    		}
    		
    	}
    	
    	return highestCount;
    	
    }
}