package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
		assertEquals(2, solution10.solution(100, new int[] {1,2,99,5,1,99,2}));
		assertEquals(2, solution10.solution(5, new int[] {1,2,100,5,1,1,2}));
		assertEquals(3, solution10.solution(3, new int[] {1,1,1,1,1,1,99}));
		assertEquals(3, solution10.solution(100, new int[] {98,1,1,1,99,1,1,100}));
	}
	
	@Test
	void testBigValue() {
		assertEquals(2, solution10.solution(1_000_000_000, new int[] {1,2,999_999_999,1_000_000_000,1,1,3}));
		assertEquals(3, solution10.solution(1_000_000_000, new int[] {1,2,999_999_999,1_000_000_000,1,1,1_000_000_000}));
		assertEquals(5, solution10.solution(3, new int[] {1,2,999_999_999,1_000_000_000,1,1,1,1_000_000_000}));
	}
	
	@Test
	void testShortLength() {
		assertEquals(1, solution10.solution(1, new int[] {1}));
		assertEquals(0, solution10.solution(1, new int[] {0}));
		assertEquals(1, solution10.solution(1, new int[] {1_000_000_000}));
	}
	
	@Test
	void testSmallValue() {
		assertEquals(3, solution10.solution(1, new int[] {1,3,5}));
		assertEquals(10, solution10.solution(1, new int[] {1,1,1,1,1,1,1,1,1,1}));
		assertEquals(4, solution10.solution(6, new int[] {1,1,5,1,5,1,6,1,1,1,1,1,1}));
	}
	
	@Disabled
	@Test
	void testLargeLengthAndValueRandom() {
		//large1 random
		int testArray[] = new int[100_000];
		
		Random rn = new Random();
		int range = 1_000_000_000;
		for(int i = 0 ; i < 100_000; i ++) {
			int randomNum =  rn.nextInt(range);
			testArray[i] = randomNum ;
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(99894, solution10.solution(1_000_000, testArray));
        });
		
	}
	
	@Test
	void testLongLength() {
		int testArray[] = new int[100_000];
		for(int i = 0 ; i < 100_000 ; i++) {
			testArray[i] = 1_000_000_000 ;
		}
		
		// @TODO performance issue
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(100_000, solution10.solution(1, testArray));
        });
	}

}
