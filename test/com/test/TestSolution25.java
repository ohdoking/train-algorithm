package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * 
 * @author ohdoking
 *
 */
class TestSolution25 {

	Solution25 solution25;
	
	@BeforeEach
	void setUp() throws Exception {
		solution25 = new Solution25();
	}

	@Test
	void testSimple() {
		assertEquals(49, solution25.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
	
	@Test
	void testNull() {
		assertEquals(0, solution25.maxArea(new int[]{}));
	}
	
	@Test
	void testSame() {
		assertEquals(13, solution25.maxArea(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}));

	}
	
	@Test
	void testExtremeValue() {
		int[] arr = new int[10000000];
		for(int i = 0 ; i < 10000000; i++){
			arr[i] = i;
		}
		// and timeout test
		assertTimeout(Duration.ofMillis(1000), () -> {
			assertEquals(2147482498, solution25.maxArea(arr));
		});
	}
	

}
