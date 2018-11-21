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
 * 
 *  
 *  Write an efficient algorithm for the following assumptions:
 *  
 *	N is an integer within the range [2..100,000];
 *	each element of array A is an integer within the range [−1,000..1,000].
 *
 * @author ohdoking
 *
 */
class TestSolution4 {

	Solution4 solution4;
	
	@BeforeEach
	void setUp() throws Exception {
		solution4 = new Solution4(); 
	}
	

	@Test
	void testSimple() {
		
		assertEquals(4, solution4.solution(new int[]{1,2,4,5,6}));
		assertEquals(1, solution4.solution(new int[]{3,1,2,4,3}));
		assertEquals(2, solution4.solution(new int[]{-1,-1,1,2,4,3}));
		assertEquals(97, solution4.solution(new int[]{-100,-1,1,2,4,3}));
		
		assertEquals(2, solution4.solution(new int[]{-100,99,-98,98,-99,100}));
		
	}
	
	@Test
	void testSmall() {
		
		assertEquals(1, solution4.solution(new int[]{1}));
		assertEquals(1, solution4.solution(new int[]{1,2}));
		
	}
	
	@Test
	void testNegative() {
		
		assertEquals(1, solution4.solution(new int[]{-1000,-999}));
		
	}
	
	@Test
	void testLarge() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		for(int i = 1 ; i < 100000; i ++) {
			list.add(i);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(100), () -> {
			assertEquals(24810, solution4.solution(list.stream().mapToInt(i->i).toArray()));
        });
		
	}
	
	@Test
	void testLargeNegative() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		for(int i = -1000 ; i < 500; i ++) {
			list.add(i);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(100), () -> {
			assertEquals(360, solution4.solution(list.stream().mapToInt(i->i).toArray()));
        });
		
//		1
		
	}
	
	@Test
	void testLargeNegative2() {
		//large1 random
		List<Integer> list = new LinkedList();
		
		for(int i = -499 ; i < 500; i ++) {
			list.add(i);
		}
		
		// and timeout test
		assertTimeout(Duration.ofMillis(100), () -> {
			assertEquals(998, solution4.solution(list.stream().mapToInt(i->i).toArray()));
        });
		
//		1
		
	}
}
