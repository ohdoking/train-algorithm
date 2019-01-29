package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution22 {

	Solution22 solution22;

	@BeforeEach
	void setUp() throws Exception {
		solution22 = new Solution22();
	}

	@Test
	void test() {
		assertEquals(42, solution22.myAtoi("42"));
		assertEquals(-42, solution22.myAtoi("   -42"));
		assertEquals(4193, solution22.myAtoi("4193 with words"));
		assertEquals(0, solution22.myAtoi("words and 987"));
	}

	@Test
	void testNull() {
		assertEquals(0, solution22.myAtoi(""));
	}

	@Test
	void testOnlyMinus() {
		assertEquals(0, solution22.myAtoi("-"));
	}

	@Test
	void testOverFlowMinus() {
		assertEquals(Integer.MIN_VALUE, solution22.myAtoi("-91283472332"));
	}

	@Test
	void testOverFlow() {
		assertEquals(Integer.MAX_VALUE, solution22.myAtoi("91283472332"));
	}
}
