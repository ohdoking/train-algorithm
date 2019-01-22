package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author ohdoking
 *
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * My solution is using stream API for removing duplicate
 * stream API has the function of removing duplicate elements
 * that method name is distinct()
 * 
 * s -> char array
 * Steam.of(char.array).distinct.size()
 * 
 * I misunderstood this question.
 * 
 * I try to solve this problem again.
 * 
 * My solution is using a map for checking repeating
 * 
 * i'm gonna walk you through about my solution.
 * 
 * i'm gonna declare one variable named longestText for assigning to the longest text
 * 
 * and i'm gonna implement for loop for find the longest text.
 * when i'm gonna find a repeat character as this loop repeat.
 * i'm gonna initialize this map and find search repeat character again 
 * 
 * 
 * [abcabcbb]
 * 
 * i - length : 0 / a
 * 	tempLongestText = a
 * 	set = [a]
 * 
 * i - length : 1 / b
 * 	tempLongestText = ab
 * 	set = [a,b]
 * 
 * i - length : 2 / c
 * 	tempLongestText = abc
 * 	set = [a,b,c]
 * 
 * i - length : 3 / a
 * 	longestText = abc
 * 	initialize
 * 	tempLongestText = a
 * 	set = [a]
 * 
 * i - length : 4 / b
 * 	tempLongestText = ab
 * 	set = [a,b]
 * 
 * i - length : 5 / c
 * 	tempLongestText = abc
 * 	set = [a,b,c]
 * 
 * i - length : 6 / b
 * 	longestText = abc
 * 	initialize
 *  tempLongestText = b
 * 	set = [b]
 * 
 * i - length : 7 / b
 * 	longestText = abc
 * 	initialize
 *  tempLongestText = b
 * 	set = [b]
 * 
 * 
 * this is my third solution for sovling this problems
 * 
 * 
 */
class Solution17 {
    public int lengthOfLongestSubstring(String s) {
    	if(s.equals(" ")) {
    		return 1;
    	}
    	StringBuilder longestText = new StringBuilder();
    	StringBuilder tempLongestText = new StringBuilder();
    	
    	List<Character> set = new ArrayList<Character>();
    	char[] arr = s.toCharArray();
    	
    	for(int i = 0; i < arr.length ; i++) {
    		
    		if(set.contains(arr[i])) {
    			tempLongestText = new StringBuilder();
    			set = new ArrayList<Character>();
    		}
    		
    		//and then restart to stack the data 
			tempLongestText.append(arr[i]);
			set.add(arr[i]);
    		
			if(longestText.length() < tempLongestText.length()) {
				longestText = tempLongestText;
			}
    		
    	}
    	
    	return longestText.length();
    }
}