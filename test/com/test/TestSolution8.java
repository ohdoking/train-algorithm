package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution8 {
	
	Solution8 solution8;
	
	@BeforeEach
	void setUp() throws Exception {
		solution8 = new Solution8(); 
	}

	@Test
	void test() {
		assertEquals("SUMMER", solution8.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
		//assertEquals("AUTUMN", solution8.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
	}

}
