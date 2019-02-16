package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution21 {
	
	Solution21 solution21;
	
	@BeforeEach
	void setUp() throws Exception {
		solution21 = new Solution21();
	}

	@Test
	void test() {
		assertEquals(321, solution21.reverse(123));
		assertEquals(-321, solution21.reverse(-123));
		assertEquals(21, solution21.reverse(120));
	}

	@Test
	void testBigValue() {
		assertEquals(0, solution21.reverse(1534236469));
	}

}
