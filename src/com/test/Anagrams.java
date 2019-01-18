package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public long nPr(char[] arr, String word) {
		//List<String> list = new LinkedList<>(Arrays.asList(arr));
		
		Set<Character> set = new HashSet<Character>();
		for(char ch : arr){
			set.add(ch);
		}
		int characterLength = set.size();
		
		char[] stadardWord = word.toCharArray();
		
		long result = 0;
		
		List<Character> tempList = new ArrayList<Character>();
		for(char ch : arr){
			tempList.add(ch);
		}
		Collections.sort(tempList);
		
		for(int i = 0 ; i < arr.length ; i++ ) {
			//LinkedList<Character> characterList = new LinkedList<Character>(Chars.asList(string.toCharArray()));

			/*
			 * 
			 * 
			 * 
			 * A B A B
			 * AA 2!/(2!) = 1
			 * ABAB = 1
The number of anagrams that start with I is 10!/(3!1!2!4!) = 12600
The number of anagrams that start with MII is 8!/(2!0!2!4!) = 420
The number of anagrams that start with MIP is 8!/(3!0!1!4!) = 280
The number of anagrams that start with MISI is 7!/(2!0!2!3!) = 210
The number of anagrams that start with MISP is 7!/(3!0!1!3!) = 140
The number of anagrams that start with MISSII is 5!/(1!0!2!2!) = 30
The number of anagrams that start with MISSIP is 5!/(2!0!1!2!) = 30

			 */
			List<Character> tempList2 = new ArrayList<Character>(tempList);
			for (Character charater : set) {
				if(charater.equals(stadardWord[i])) {
					break;
				}
				result += nPr(tempList2.toArray(new Character[tempList2.size()]), characterLength);
				swap(tempList2, charater);
			}
			
			tempList.remove(0);
			set = new HashSet<Character>();
			for(char ch : tempList){
				set.add(ch);
			}
		}
		
		return result+1;
	}
	
	private void swap(List<Character> tempList, Character charater) {
		for(int i = 0 ; i < tempList.size() ; i++) {
			Character firstChar = tempList.get(i);
			if(tempList.get(i).equals(charater)) {
				tempList.set(i, firstChar);
				tempList.set(0, tempList.get(i));
			}
		}
		
	}

	public long nPr(Character[] arr, int size) {
		
		int denominator = 1;// 분모
		int numerator = 1;// 분자
		
		int[] duplicateNumber = new int[size];
		
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
		
		return denominator/numerator;
	}
}