package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution18 {
	
	Solution18 solution18;
	
	@BeforeEach
	void setUp() throws Exception {
		solution18 = new Solution18(); 
	}

	@Test
	void test() {
		assertEquals(2.0, solution18.findMedianSortedArrays(new int[]{1,3} , new int[]{2}));
		assertEquals(2.5, solution18.findMedianSortedArrays(new int[]{1,2} , new int[]{3,4}));
	}

}
