package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public State state;
	
	public BigInteger listPosition(String word) {
		
		state = new State(word);
		
		char[] arr = word.toCharArray();
		Arrays.sort(arr);
		permutation(String.valueOf(arr));	
		
		return new BigInteger(String.valueOf(state.getCount()));
	}
	
	public void permutation(String str) { 
	    permutation("", str); 
	}

	private void permutation(String prefix, String str) {
		if(state.isState() == false) {
			return ;
		}
	    int n = str.length();
	    if (n == 0) {
	    	if(!state.getList().contains(prefix)) {
	    		state.getList().add(prefix);
	    		state.setCount(state.getCount()+1);
	    		if(state.getStdWord().equals(prefix)) {
	    			state.setState(false);
	    		}
	    	}
	    	
	    }
	    else {
	        for (int i = 0; i < n; i++) {
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	
	class State{
		private long count;
		private String stdWord;
		private boolean state ;
		private List<String> list;
		
		public State(String word) {
			count = 0;
			stdWord = word;
			state = true;
			this.list = new ArrayList<String>();
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public String getStdWord() {
			return stdWord;
		}
		public void setStdWord(String stdWord) {
			this.stdWord = stdWord;
		}
		public boolean isState() {
			return state;
		}
		public void setState(boolean state) {
			this.state = state;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		
		
	}
}