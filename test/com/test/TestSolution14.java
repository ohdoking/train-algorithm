package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author ohdoking
 *
 * Let A be a non-empty array consisting of N integers.
 * 
 * The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
class TestSolution14 {
	
	Solution14 solution14;
	
	@BeforeEach
	void setUp() throws Exception {
		solution14 = new Solution14(); 
	}

	@Test
	void testSimple() {
		assertEquals(1, solution14.solution(new int[] {1, 4, -3}));
		assertEquals(3, solution14.solution(new int[] {-8, 4, 5, -10, 3}));
	}
	
	@Test
	void testLargeRange() {
		int testArray[] = new int[100_000];
		for(int i = 0 ; i < 100_000 ; i++) {
			testArray[i] = 1 ;
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(500), () -> {
			assertEquals(2, solution14.solution(testArray));
        });
	}
	
	@Test
	void testShortRange() {
		assertEquals(2, solution14.solution(new int[] {1}));
	}
	
	@Test
	void testSmallValue() {
		assertEquals(0, solution14.solution(new int[] {1, -1}));
		
	}
	
	@Test
	void testBigValue() {
		assertEquals(2_000_000_000, solution14.solution(new int[] {1_000_000_000}));
		assertEquals(0, solution14.solution(new int[] {1_000_000_000, -1_000_000_000}));
		
	}
	
	@Test
	void testBigValueLargeLange() {
		int testArray[] = new int[100_000];
		for(int i = 0 ; i < 100_000 ; i++) {
			testArray[i] = 1_000_000_000 ;
		}
		// and timeout test
		assertTimeout(Duration.ofMillis(1500), () -> {
			assertEquals(2_000_000_000, solution14.solution(testArray));
        });
		
	}

}
