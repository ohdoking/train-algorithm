package com.test;

import java.util.ArrayList;
import java.util.List;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/**
 * Sieve of Eratosthenes
 * 
 * semiprime condition : p>= 3, p + 2 is prime
 * @author ohdoking
 *
 */
class Solution6 {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
    	int[] resultArray = new int[P.length];
    	
    	for(int i = 0 ; i < P.length; i++) {
    		int count = 0;
    		for(int j = P[i] ; j <= Q[i]; j++) {
    			if(divisorNumber(j).size() == 4 && isPrime(divisorNumber(j).get(2))) {
    				count++;
    			}
    		}
    		resultArray[i] = count;
    	}
    	
    	return resultArray;
    	
    }
    
    private List<Integer> divisorNumber(int n){
    	List<Integer> result = new ArrayList<>();
    	for(int i = 1 ; i <= n; i++) {
    		if(n%i == 0 && n/i == i) {
    			result.add(i);
    			result.add(i);
    		}
    		else if(n%i == 0) {
    			result.add(i);
    		}
    	}
    	return result;
    }
    
    
    
  //checks whether an int is prime or not.
    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}