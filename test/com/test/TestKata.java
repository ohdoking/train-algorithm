package com.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.test.Kata;
import com.test.Kata2;

class TestKata {

	@Test
	void test() {
		
		String testString = "what is your name";
		String expected = "your";
		
		assertEquals(expected, Kata.high(testString),"result value test");
	}

}
