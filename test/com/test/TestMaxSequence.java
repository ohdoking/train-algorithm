package com.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMaxSequence {
	@Test
	public void testEmptyArray() throws Exception {
		assertEquals("Empty arrays should have a max of 0", 0, Max.sequence(new int[] {}));
	}

	@Test
	public void testExampleArray() throws Exception {
		assertEquals("Example array should have a max of 6", 6,
				Max.sequence(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	@Test
	public void testNegativeExampleArray() throws Exception {
		assertEquals("Example array with all negative values should have a max of 0", 0,
				Max.sequence(new int[] { -2, -1, -3, -4, -1, -2, -1, -5, -4 }));
	}

	@Test
	public void testRandomArrays() throws Exception {
		for (int i = 0; i < 50; i++) {
			int[] rand = randArr((int) (Math.random() * 10 + 50));
			assertEquals("Random array solution not as expected: ", solution(rand), Max.sequence(rand));
		}
	}

	private int[] randArr(int size) {
		int[] rand = new int[size];
		for (int i = 0; i < size; i++)
			rand[i] = (int) (Math.random() * 60 - 30);
		return rand;
	}

	private int solution(int[] arr) {
		int m = 0, a = 0, s = 0;
		for (int e : arr) {
			s += e;
			m = Math.min(s, m);
			a = Math.max(a, s - m);
		}
		return a;
	}
}