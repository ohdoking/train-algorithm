package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * 	N is an integer within the range [1..100,000];
 * 	K is an integer within the range [1..1,000,000,000];
 * 	each element of array A is an integer within the range [1..1,000,000,000].
 * 
 * @author ohdoking
 *
 */
class TestSolution10 {
	
	Solution10 solution10;
	
	@BeforeEach
	void setUp() throws Exception {
		solution10 = new Solution10(); 
	}

	@Test
	void testSimple() {
		assertEquals(3, solution10.solution(4, new int[] {1,2,3,4,1,1,3}));
		assertEquals(2, solution10.solution(5, new int[] {1,2,3,5,1,1,2}));
	}
	
	

}
