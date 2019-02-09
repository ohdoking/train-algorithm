package com.test;

import java.util.Arrays;

/**
 *
 * Longest Common Prefix
 *
 * @author ohdoking
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 */
class Solution29 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();

        boolean state = true;
        
        Arrays.sort(strs, (a, b)-> a.length() - b.length());
        String standardString = strs[0];

        for(int i = 0 ; i < standardString.length(); i++){
            for(String s : strs){
                if(standardString.charAt(i) != s.charAt(i)){
                    state = false;
                    break;
                }
            }
            if(!state){
                break;
            }
            result.append(standardString.charAt(i));
        }

        return result.toString();
    }
}