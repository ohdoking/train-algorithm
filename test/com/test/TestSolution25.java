package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 *
 * 
this is condition.

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.


 * @author ohdoking
 *
 */
class TestSolution25 {

	Solution2 solution2;
	
	@BeforeEach
	void setUp() throws Exception {
		solution2 = new Solution2(); 
	}

	@Test
	void testSimple() {
		
		assertEquals(3, solution2.solution(10, 85, 30));
		assertEquals(90, solution2.solution(10, 100, 1));
		
	}
	
	@Test
	void testNull() {
		
		assertEquals(0, solution2.solution(10, 100, 0));
		
	}
	
	@Test
	void testSame() {
		
		assertEquals(0, solution2.solution(10, 10, 1));
		
	}
	
	@Test
	void testExtremePosition() {
		
		//extreme_position
		assertEquals(1000000000, solution2.solution(0, 1000000000, 1));
		
	}
	

}
