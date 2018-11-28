package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 *	N is an integer within the range [3..100,000];
 *	each element of array A is an integer within the range [−10,000..10,000].
 *
 * @author ohdoking
 *
 */
class TestSolution11 {
	
	Solution11 solution11;
	
	@BeforeEach
	void setUp() throws Exception {
		solution11 = new Solution11(); 
	}
		    
	@Test
	void testSimple() {
		assertEquals(17, solution11.solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2}));
		assertEquals(18, solution11.solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2, 2}));
		assertEquals(8, solution11.solution(new int[] {3, 2, 6, -1, 4}));
	}
	
	@Test
	void testLargeRange() {
		int testArray[] = new int[100_000];
		for(int i = 0 ; i < 100_000 ; i++) {
			testArray[i] = 10_000 ;
		}
		assertEquals(10_000 * 100_000 - 30_000, solution11.solution(testArray));
	}
	
	@Test
	void testShortRange() {
		assertEquals(0, solution11.solution(new int[] {3,1,-1}));
		assertEquals(1, solution11.solution(new int[] {3,1,-10_000,-1}));
		
	}
	
	@Test
	void testSmallValue() {
		assertEquals(6, solution11.solution(new int[] {3, -1, 6, -1, 4}));
		
	}
	
	@Test
	void testBigValue() {
		assertEquals(20_000, solution11.solution(new int[] {10_000, 10_000, 10_000, -2, 10_000}));
		
	}

}
