package com.test;

import java.util.PriorityQueue;

/**
 *
 * Implement strStr()
 *
 * @author ohdoking
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * nice answer example
 *
 * public int strStr(String haystack, String needle) {
 *   for (int i = 0; ; i++) {
 *     for (int j = 0; ; j++) {
 *       if (j == needle.length()) return i;
 *       if (i + j == haystack.length()) return -1;
 *       if (needle.charAt(j) != haystack.charAt(i + j)) break;
 *     }
 *   }
 * }
 */
class Solution37 {
    public int strStr(String haystack, String needle) {
        return haystack.contains(needle) ? getIndex(haystack, needle) : -1;
    }

    private int getIndex(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0){
            return 0;
        }
        String[] strings = haystack.split("");
        int start = 0;

        boolean state = true;

        while(state){
            if(haystack.charAt(start) ==  needle.charAt(0)){
                boolean tempState = true;
                for(int i = 1 ; i < needle.length(); i++){
                    if(haystack.charAt(start + i) != needle.charAt(i)){
                        tempState = false;
                        break;
                    }
                }
                if(tempState){
                    state = false;
                }
                else{
                    start++;
                }
            }
            else{
                start++;
            }




        }
        return start;
    }
}