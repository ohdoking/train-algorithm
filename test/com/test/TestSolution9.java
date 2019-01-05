package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution9 {
	
	Solution9 solution9;
	
	@BeforeEach
	void setUp() throws Exception {
		solution9 = new Solution9(); 
	}

	@Test
	void test() {
		//assertEquals("aabaabab", solution9.solution(5,3));
		assertEquals("aabaabb", solution9.solution(3,3));
		assertEquals("bbabb", solution9.solution(1,4));
		assertEquals("ab", solution9.solution(1,1));
		assertEquals("bb", solution9.solution(0,2));
		assertEquals("b", solution9.solution(0,1));
		assertEquals("a", solution9.solution(1,0));
		assertEquals("", solution9.solution(0,0));
	}

}
