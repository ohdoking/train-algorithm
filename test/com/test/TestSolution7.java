package com.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N and M are integers within the range [1..30,000];
 * each element of arrays A, B, C is an integer within the range [1..2*M];
 * A[K] ≤ B[K].
 * 
 * @author ohdoking
 *
 */
class TestSolution7 {
	
	Solution7 solution7;
	
	@BeforeEach
	void setUp() throws Exception {
		solution7 = new Solution7(); 
	}

	@Test
	void testSimple() {
		assertEquals(4, solution7.solution(new int[] {1, 4, 5, 8}, new int[] {4, 5, 9, 10}, new int[] {4, 6, 7, 10, 2}));
	}
	
	@Test
	void testUseAllPlanksAndNail() {
		assertEquals(4, solution7.solution(new int[] {1, 4, 5, 8}, new int[] {4, 5, 9, 10}, new int[] {4, 6, 7, 10}));
	}
		
	@Test
	void testFailPutNailInAllPranks() {
		assertEquals(-1, solution7.solution(new int[] {1, 4, 5, 8}, new int[] {4, 5, 9, 10}, new int[] {4, 6, 7}));
		assertEquals(-1, solution7.solution(new int[] {1, 4, 5, 8}, new int[] {4, 5, 9, 10}, new int[] {100}));
	}

	@Test
	void testLargeValue() {
		assertEquals(1, solution7.solution(new int[] {0}, new int[] {30000}, new int[] {30000}));
	}
	
	//few_nails_in_the_same_place
	@Test
	void testFewNailsInTheSamePlace() {
		assertEquals(1, solution7.solution(new int[] {1, 1, 1}, new int[] {3,10,4}, new int[] {1,1,1,1}));
		assertEquals(-1, solution7.solution(new int[] {1, 2, 3}, new int[] {2,3,4}, new int[] {1,1,1}));
	}
	
	@Test
	void testLargeLengthAndValue() {
		//large1 random
		List<Integer> list = new ArrayList();
		List<Integer> list2 = new ArrayList();
		
		for(int i = 1 ; i <= 30000; i ++) {
			list.add(i);
			list2.add(30000-i);
		}
		
		int[] arr = list.stream().mapToInt(i->i).toArray();
		int[] arr2 = list2.stream().mapToInt(i->i).toArray();
		
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(-1, solution7.solution(arr, arr2,  new int[] {1}));
        });
		
	}
	
	@Test
	void testLargeLengthAndValue2() {
		//large1 random
		List<Integer> list = new ArrayList();
		List<Integer> list2 = new ArrayList();
		
		for(int i = 1 ; i < 30000; i ++) {
			list.add(1);
			list2.add(30000-i);
		}
		
		int[] arr = list.stream().mapToInt(i->i).toArray();
		int[] arr2 = list2.stream().mapToInt(i->i).toArray();
		
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(1, solution7.solution(arr, arr2,  new int[] {1}));
        });
		
	}
	
	
	/*@Test
	void testLargeLengthAndValueRandom() {
		//large1 random
		List<Integer> list = new ArrayList();
		List<Integer> list2 = new ArrayList();
		List<Integer> list3 = new ArrayList();
		
		Random rn = new Random();
		int range = 60000;
		for(int i = 1 ; i <= 30000; i ++) {
			int randomNum =  rn.nextInt(range);
			list.add(randomNum);
			randomNum =  rn.nextInt(range);
			list2.add(randomNum);
			randomNum =  rn.nextInt(range);
			list3.add(randomNum);
		}
		
		int[] arr = list.stream().mapToInt(i->i).toArray();
		int[] arr2 = list2.stream().mapToInt(i->i).toArray();
		int[] arr3 = list3.stream().mapToInt(i->i).toArray();
		
		// and timeout test
		assertTimeout(Duration.ofMillis(00), () -> {
			assertEquals(6000, solution7.solution(arr, arr2, arr3));
        });
		
	}*/
	
	
}