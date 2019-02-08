package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution29{
	Solution29 solution29;

	@BeforeEach
	void setUp() throws Exception {
		solution29 = new Solution29();
	}

	@Test
	void test() {
		assertEquals("fl", solution29.longestCommonPrefix(new String[]{"flower","flow","flight"}));
		assertEquals("", solution29.longestCommonPrefix(new String[]{"dog","racecar","car"}));
		assertEquals("a", solution29.longestCommonPrefix(new String[]{"aa","a"}));
	}

	@Test
	void testNullInCase() {
		assertEquals("", solution29.longestCommonPrefix(new String[]{}));
		assertEquals("", solution29.longestCommonPrefix(new String[]{"","b"}));
	}

}
