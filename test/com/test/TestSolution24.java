package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution24 {

	Solution24 solution24;

	@BeforeEach
	void setUp() throws Exception {
		solution24 = new Solution24();
	}

	@Test
	void test() {
		assertEquals(false, solution24.isMatch("aa","a"));
		assertEquals(true, solution24.isMatch("aa","a*"));
		assertEquals(true, solution24.isMatch("ab",".*"));
		assertEquals(true, solution24.isMatch("aab","c*a*b"));
		assertEquals(false, solution24.isMatch("mississippi","mis*is*p*."));
	}

}
