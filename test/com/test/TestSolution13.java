package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution13 {
	
	Solution13 solution13;
	
	@BeforeEach
	void setUp() throws Exception {
		solution13 = new Solution13(); 
	}

	@Test
	void test() {
		assertEquals("abcabcabcababababc", solution13.solution("3[abc]4[ab]c"));
		assertEquals("aaabaaab", solution13.solution("2[3[a]b]"));
		assertEquals("aaaaaaaaaa", solution13.solution("10[a]"));
	}

}
