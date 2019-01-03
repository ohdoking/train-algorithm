package com.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPalindrome {

	Palindrome palindrome;
	
	@BeforeEach
	void setUp() throws Exception {
		palindrome = new Palindrome(); 
	}

	@Test
	void test() {
		assertTrue("this is Palindrome : ", palindrome.isPalindrome("Deleveled"));
	}
	@Test
	void testEmpty() {
		assertTrue("this is Palindrome : ", palindrome.isPalindrome(""));
	}
}
