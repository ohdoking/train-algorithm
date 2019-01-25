package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution19 {
	
	Solution19 solution19;
	
	@BeforeEach
	void setUp() throws Exception {
		solution19 = new Solution19();
	}

	@Test
	void test() {
		assertEquals("PAHNAPLSIIGYIR", solution19.convert("PAYPALISHIRING", 3));
		assertEquals("PINALSIGYAHRPI", solution19.convert("PAYPALISHIRING",4));
	}

	@Test
	void testSingleValue() {
		assertEquals("A", solution19.convert("A", 1));
	}

	@Test
	void testDoubleValue() {
		assertEquals("AB", solution19.convert("AB", 1));
	}

}
