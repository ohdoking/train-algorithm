package com.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Anagrams
 * 
 * @author ohdoking
 * 
 *         Alphabetic Anagrams
 * 
 * 
 *         Consider a "word" as any sequence of capital letters A-Z (not limited
 *         to just "dictionary words"). For any word with at least two different
 *         letters, there are other words composed of the same letters but in a
 *         different order (for instance, STATIONARILY/ANTIROYALIST, which
 *         happen to both be dictionary words; for our purposes "AAIILNORSTTY"
 *         is also a "word" composed of the same letters as these two).
 * 
 *         We can then assign a number to every word, based on where it falls in
 *         an alphabetically sorted list of all words made up of the same group
 *         of letters. One way to do this would be to generate the entire list
 *         of words and find the desired one, but this would be slow if the word
 *         is long.
 * 
 *         Given a word, return its number. Your function should be able to
 *         accept any word 25 letters or less in length (possibly with some
 *         letters repeated), and take no more than 500 milliseconds to run. To
 *         compare, when the solution code runs the 27 test cases in JS, it
 *         takes 101ms.
 * 
 *         For very large words, you'll run into number precision issues in JS
 *         (if the word's position is greater than 2^53). For the JS tests with
 *         large positions, there's some leeway (.000000001%). If you feel like
 *         you're getting it right for the smaller ranks, and only failing by
 *         rounding on the larger, submit a couple more times and see if it
 *         takes.
 * 
 *         Python, Java and Haskell have arbitrary integer precision, so you
 *         must be precise in those languages (unless someone corrects me).
 * 
 *         C# is using a long, which may not have the best precision, but the
 *         tests are locked so we can't change it.
 * 
 *         Sample words, with their rank: ABAB = 2 AAAB = 1 BAAA = 4 QUESTION =
 *         24572 BOOKKEEPER = 10743
 * 
 */
public class Anagrams {
	
	public BigInteger listPosition(String word) {
		return new BigInteger(String.valueOf(nPr(word.toCharArray(), word)));
	}
	
	public BigInteger nPr(char[] arr, String word) {
		
		BigInteger result = BigInteger.valueOf(0);
		
		char[] stadardWord = word.toCharArray();
		
		List<Character> tempList = new ArrayList<Character>();
		for(char ch : arr){
			tempList.add(ch);
		}
		
		Set<Character> set = new HashSet<Character>();
		for(char ch : arr){
			set.add(ch);
		}
		
		List<Character> myList = new ArrayList<Character>(set);
		Collections.sort(myList);
		
		for(int i = 0 ; i < arr.length ; i++ ) {
			List<Character> tempList2 = new ArrayList<Character>(tempList);
			Collections.sort(tempList2);
			for (Character charater : myList) {
				if(charater.equals(stadardWord[i])) {
					break;
				}
				result.add(nPr(tempList2.toArray(new Character[tempList2.size()])));
				swap(tempList2, charater);
			}
			
			tempList.remove(0);
			set = new HashSet<Character>();
			for(char ch : tempList){
				set.add(ch);
			}
			myList = new ArrayList<Character>(set);
			Collections.sort(myList);
		}
		
		return result.add(BigInteger.valueOf(1));
	}
	
	/**
	 * Swap data between first value and other character.
	 * @param tempList
	 * @param charater
	 */
	private void swap(List<Character> tempList, Character charater) {
		Character firstChar = tempList.get(0);
		for(int i = 0 ; i < tempList.size() ; i++) {
			if(!tempList.get(i).equals(charater)) {
				tempList.set(i, firstChar);
				tempList.set(0, tempList.get(i));
				break;
			}
		}
		
	}

	/**
	 * Permutation
	 * 
	 * Combinations Calculator (nCr)
	 * 
	 * @param arr
	 * @return
	 */
	public BigInteger nPr(Character[] arr) {
		
		long denominator = 1;// 분모
		long numerator = 1;// 분자
		
		int[] duplicateNumber = new int[26];
		
		for(int i = 1 ; i < arr.length ; i++ ) {
			denominator *= i; 
			int data = (int)arr[i];
			int offset = (int)'A';
			duplicateNumber[data-offset]++;
		}
		
		for(int i = 0 ; i < duplicateNumber.length ; i++) {
			if(duplicateNumber[i] == 0) {
				continue;
			}
			for(int j = 1 ; j <= duplicateNumber[i] ; j++) {
				numerator *= j;
			}
		}
		
		return BigInteger.valueOf(denominator).divide(BigInteger.valueOf(numerator));
	}
}