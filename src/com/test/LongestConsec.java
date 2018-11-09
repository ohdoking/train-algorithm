package com.test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class LongestConsec {
    
    public static String longestConsec(String[] strarr, int k) {
        // your code
    	if(k > strarr.length || k <= 0) {
    		return "";
    	}
    	Optional<String> resultText;
    	
    	Optional<String> result = Stream
        		.of(strarr)
        		.distinct()
        		.max((aName, bName) -> aName.length() - bName.length());
    	
    	int longestIndex = Arrays.asList(strarr).indexOf(result.get());
    		Optional<String> tempText = Stream
					.of(strarr)
					.skip(longestIndex-k+1)
					.limit(longestIndex+1)
					.reduce((x,y)->x+y);
    		
    		Optional<String> tempText2 = Stream
					.of(strarr)
					.skip(longestIndex)
					.limit(longestIndex+k-1)
					.reduce((x,y)->x+y);
    		
    		if(tempText.get().length() >= tempText2.get().length()) {
    			resultText = tempText;
    		}
    		else {
    			resultText = tempText2;
    		}
    	
    	return resultText.get();
    	
    }
}