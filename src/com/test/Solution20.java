package com.test;

/**
 * 
 * Longest Palindromic Substring
 * 
 * @author ohdoking
 *
 *         Given a string s, find the longest palindromic substring in s. You
 *         may assume that the maximum length of s is 1000.
 *         
 *         
 */
class Solution20 {
	public String longestPalindrome(String s) {

		String longestPalindromicText = "";
		
		for(int i = 0 ; i < s.length() ; i++) {
			for(int j = i ; j < s.length() ; j++) {
				String tempText = s.substring(i, j+1);
				if(checkPalindormic(tempText)) {
					if(tempText.length() >= longestPalindromicText.length()) {
						longestPalindromicText = tempText;
					}
				}
			}
		}
		
		return longestPalindromicText;
	}
	
	private boolean checkPalindormic(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}