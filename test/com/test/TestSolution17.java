package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution17 {
	
	Solution17 solution17;
	
	@BeforeEach
	void setUp() throws Exception {
		solution17 = new Solution17(); 
	}

	@Test
	void test() {
		assertEquals(3, solution17.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, solution17.lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, solution17.lengthOfLongestSubstring("pwwkew"));
	}
	@Test
	void testLastValueIsLongestValueWithoutRepeat() {
		assertEquals(3, solution17.lengthOfLongestSubstring("bbbbbabc"));
	}
	@Test
	void testLastValueIsLongestValueWithoutRepeat2() {
		assertEquals(6, solution17.lengthOfLongestSubstring("asjrgapa"));
	}
	@Test
	void testLastValueIsLongestValueWithoutRepeat3() {
		assertEquals(6, solution17.lengthOfLongestSubstring("ohvhjdml"));
	}
	@Test
	void testNullValue() {
		assertEquals(0, solution17.lengthOfLongestSubstring(""));
	}
	@Test
	void testSpaceValue() {
		assertEquals(1, solution17.lengthOfLongestSubstring(" "));
	}

}
