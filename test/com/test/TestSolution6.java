package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 * Write an efficient algorithm for the following assumptions:
 *
 *	N is an integer within the range [1..50,000];
 * 	M is an integer within the range [1..30,000];
 * 	each element of arrays P, Q is an integer within the range [1..N];
 *	P[i] ≤ Q[i].


 * @author ohdoking
 *
 */
class TestSolution6 {
	
	Solution6 solution6;
	
	@BeforeEach
	void setUp() throws Exception {
		solution6 = new Solution6(); 
	}

	@Test
	void testSimple() {
		assertArrayEquals(new int[] {10, 4, 0}, solution6.solution(26, new int[] {1, 4, 16}, new int[] {26, 10, 20}));
		assertArrayEquals(new int[] {0}, solution6.solution(26, new int[] {16}, new int[] {20}));
	}
	
	@Test
	void testShortArray() {
		assertArrayEquals(new int[] {0}, solution6.solution(1, new int[] {1}, new int[] {1}));
	}
	
	@Test
	void testLargeValue() {
		assertArrayEquals(new int[] {0}, solution6.solution(26, new int[] {1}, new int[] {50000}));
		assertArrayEquals(new int[] {0}, solution6.solution(26, new int[] {30000}, new int[] {50000}));
	}

}
