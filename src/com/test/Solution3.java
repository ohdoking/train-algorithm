package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  PermMissingElem
 *  
    An array A consisting of N different integers is given. 
	he array contains integers in the range [1..(N + 1)], 
	which means that exactly one element is missing.
	Your goal is to find that missing element.
	
 * @author ohdoking
 *
 */
class Solution3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	int result = 0;

    	List<Integer> list = Arrays
    		.stream(A)
    		.boxed()
    		.sorted()
    		.collect(Collectors.toList());
    	
    	// exception
    	if(list.size() == 0 || list.get(0) != 1) {
    		return 1;
    	}
    	// value is 2 but array size is 1
    	if(list.get(0) == 2 && list.size() == 1) {
			return list.get(0) - 1;
		}
    	
    	for(int i = 0 ; i < list.size(); i++) {
    		if(i + 1 != list.size() && list.get(i) + 1 == list.get(i + 1)) {
    			continue;
    		}
    		result = list.get(i) + 1;
    		break;
    	}
    	
    	return result;
    	
    }
}