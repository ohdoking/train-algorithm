package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution1 {
	
	Solution1 solution1;
	
	@BeforeEach
	void setUp() throws Exception {
		solution1 = new Solution1(); 
	}

	@Test
	void test() {
//		assertEquals(3, solution1.solution(1111));
//		assertEquals(0, solution1.solution(1));
		assertEquals(0, solution1.solution(2147483647));
		assertEquals(1, solution1.solution(5));
	}

}
