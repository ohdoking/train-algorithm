package com.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ToSmallest {
    
	/**
	 *  testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");
        
           testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");
        
	 * @param n
	 * @return
	 */
    public static long[] smallest(long n) {
        // your code
    	
    	List<String> list = new LinkedList<String>();
    	list.addAll(Arrays.asList(String.valueOf(n).split("")));
    	
    	boolean reverse = false;
    	
    	
    	long[] result = new long[3]; 
    	
    	int minIdx =  IntStream
    			.range(0,list.size())
    			.filter(i -> i != 0)// excepton first value
                .reduce((i,j) -> Integer.valueOf(list.get(i)) >= Integer.valueOf(list.get(j)) ? j : i)
                .getAsInt();  
    	
    	for(int i = 0 ; i < list.size() ; i++) {
//    		if(Integer.valueOf(list.get(i)) == Integer.valueOf(list.get(minIdx))) {
//    			continue;
//    		}
    		if(Integer.valueOf(list.get(i)) < Integer.valueOf(list.get(minIdx))) {
    			continue;
    		}
    		
			
    		if(Integer.valueOf(list.get(minIdx)) == 0) {
    			result[1] = i;
        		result[2] = minIdx;

    		}
    		else {
    			result[1] = minIdx;
        		result[2] = i;
    		}
    		
    		list.add(i, list.get(minIdx));
			list.remove(minIdx+1);
    		
    		break;
    	}
    	
    	
    	result[0] = Long.valueOf(String.join("", list));
    	
    	return result;
    	
    }
}