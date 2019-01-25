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
//		assertEquals(3, solution1.solution(1111));
//		assertEquals(0, solution1.solution(1));
		assertEquals("PAHNAPLSIIGYIR", solution19.convert("PAYPALISHIRING", 3));
		assertEquals("PINALSIGYAHRPI", solution19.convert("PAYPALISHIRING",4));
	}

}
