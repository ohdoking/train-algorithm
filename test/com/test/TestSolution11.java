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
		//assertEquals(17, solution11.solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2}));
		assertEquals(8, solution11.solution(new int[] {3, 2, 6, -1, 4}));
		assertEquals(5, solution11.solution(new int[] {3, -1, 6, -1, 4}));
	}

}
