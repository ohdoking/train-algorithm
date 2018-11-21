package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 *	Write an efficient algorithm for the following assumptions:
 *
 *	Z is an integer within the range [1..6,000];
 *	each element of arrays A, B is an integer within the range [1..2,147,483,647].
 *
 * @author ohdoking
 *
 */
class TestSolution5 {
	
	Solution5 solution5;
	
	@BeforeEach
	void setUp() throws Exception {
		solution5 = new Solution5(); 
	}

	@Test
	void testSimple() {
		
		assertEquals(1, solution5.solution(new int[] {15, 10, 3}, new int[] {75, 30, 5}));
		assertEquals(3, solution5.solution(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
		assertEquals(1, solution5.solution(new int[] {3, 2, 1}, new int[] {1, 2, 3}));

	}
	
	@Test
	void testShortLength() {
		
		assertEquals(0, solution5.solution(new int[] {1}, new int[] {1000}));

	}
	
	@Test
	void testLargeValue() {
		
		assertEquals(1, solution5.solution(new int[] {2147483647, 3}, new int[] {2147483647, 1}));
		
	}
	
	@Test
	void testLargeLengthAndValue() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		for(int i = 0 ; i < 6000; i ++) {
			list.add(2147483647);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(6000, solution5.solution(list.stream().mapToInt(i->i).toArray(), list.stream().mapToInt(i->i).toArray()));
        });
		
	}
	
	@Test
	void testLargeLengthAndValueRandom() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		Random rn = new Random();
		int range = 2147483647;
		for(int i = 0 ; i < 6000; i ++) {
			int randomNum =  rn.nextInt(range);
			list.add(randomNum);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(500), () -> {
			assertEquals(6000, solution5.solution(list.stream().mapToInt(i->i).toArray(), list.stream().mapToInt(i->i).toArray()));
        });
		
	}

}
