package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolution3 {

	Solution3 solution3;
	
	@BeforeEach
	void setUp() throws Exception {
		solution3 = new Solution3(); 
	}

	@Test
	void testSimple() {
		
		//simple
		assertEquals(3, solution3.solution(new int[]{1,2,4,5,6}));
		assertEquals(5, solution3.solution(new int[]{1,2,4,3,6}));
		
	}
	
	@Test
	void testEmptyAndSingle() {
		
		//empty_and_single
		assertEquals(1, solution3.solution(new int[]{}));
		assertEquals(2, solution3.solution(new int[]{1}));
		
	}
	
	@Test
	void testMissingFirstOrLast() {
		
		//missing_first_or_last
		assertEquals(6, solution3.solution(new int[]{1,2,3,4,5}));
		assertEquals(1, solution3.solution(new int[]{2,3,4,5}));
		assertEquals(1, solution3.solution(new int[]{2}));
		
	}
	
	@Test
	void testDouble() {
		
		//double
		assertEquals(4, solution3.solution(new int[]{1,2,3,3,3,5,6}));
		
	}
	
	@Test
	void testLargeRandom() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		Random rn = new Random();
		int range = 100000;
		int randomNum =  rn.nextInt(range);
		for(int i = 1 ; i < 100000; i ++) {
			if(i == randomNum) {
				continue;
			}
			list.add(i);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(100), () -> {
			assertEquals(randomNum, solution3.solution(list.stream().mapToInt(i->i).toArray()));
        });
		
	}

}
