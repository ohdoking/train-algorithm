package com.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/**
 * The goal is to check whether the sets of prime divisors of integers N and M 
 * are exactly the same.
 * 
 * @TODO performance issue - specific large value is timeout
 * 
 * @author ohdoking
 *
 */
class Solution5 {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
    	
    	return (int) IntStream
    			.range(0, A.length) // array length
    			.filter(i -> primeFactors(A[i]).equals(primeFactors(B[i]))) // compare
    			.count();
    }
    
    
    /**
     * make primeFactors list
     * 
     * @param n 
     * @return
     */
    public List<Integer> primeFactors(int n) 
    { 
    	List<Integer> resultList = new ArrayList<>();
    	
        // Print the number of 2s that divide n 
        while (n%2==0) 
        { 
        	resultList.add(2);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
            	resultList.add(i);
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) {
        	resultList.add(n);
        }
         
        return resultList
        		.stream()
        		.distinct() // remove duplicate
        		.sorted() // for compare
        		.collect(Collectors.toList());
    } 
}