package com.test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.test.Xbonacci;

import org.junit.Before;
import org.junit.After;
import java.util.Random;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static java.util.Arrays.copyOf;

public class TestXbonacci {
	private Xbonacci variabonacci;

	@Before
	public void setUp() throws Exception {
		variabonacci = new Xbonacci();
	}

	@After
	public void tearDown() throws Exception {
		variabonacci = null;
	}

	@Test
	public void basicTests() {
		assertArrayEquals(new double[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },
				variabonacci.xbonacci(new double[] { 0, 1 }, 10));
		assertArrayEquals(new double[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 },
				variabonacci.xbonacci(new double[] { 1, 1 }, 10));
		assertArrayEquals(new double[] { 0, 0, 0, 0, 1, 1, 2, 4, 8, 16 },
				variabonacci.xbonacci(new double[] { 0, 0, 0, 0, 1 }, 10));
		assertArrayEquals(new double[] { 1, 0, 0, 0, 0, 0, 1, 2, 3, 6 },
				variabonacci.xbonacci(new double[] { 1, 0, 0, 0, 0, 0, 1 }, 10));
		assertArrayEquals(new double[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256 },
				variabonacci.xbonacci(new double[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 20));
		assertArrayEquals(new double[] { 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				variabonacci.xbonacci(new double[] { 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 10));
		assertArrayEquals(new double[] { 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5, 0.5, 1, 2, 4, 8, 16, 32, 64, 128 },
				variabonacci.xbonacci(new double[] { 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 20));
		assertArrayEquals(new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				variabonacci.xbonacci(new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 20));
		assertArrayEquals(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				variabonacci.xbonacci(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, 9));
		assertArrayEquals(new double[] {}, variabonacci.xbonacci(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, 0));

	}

	@Test
	public void randomTests() {
		double[] sign;
		int n, signlen = randInt(1, 20);
		for (int i = 0; i < 40; i++) {
			sign = new double[signlen];
			for (int j = 0; j < signlen; j++)
				sign[j] = randInt(0, 20);
			n = randInt(0, 50) + signlen;

			System.out.println("Testing for signature: " + Arrays.toString(sign) + " and n: " + n);
			assertArrayEquals("It should work with random inputs too", soluzionacci(sign, n),
					variabonacci.xbonacci(sign, n));

		}
	}

	private void assertArrayEquals(double[] expecteds, double[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	private void assertArrayEquals(String message, double[] expecteds, double[] actuals) {
		for (int i = 0; i < actuals.length; i++)
			assertEquals(expecteds[i], actuals[i], 1e-10);
	}

	private double[] soluzionacci(double[] s, int n) {
		double[] res = new double[n];
		double sum = 0;
		res = copyOf(s, n);

		for (int i = s.length; i < n; i++) {
			sum = 0;
			for (int j = 1; j <= s.length; j++)
				sum += res[i - j];
			res[i] = sum;
		}

		return res;
	}

	private int randInt(int aStart, int aEnd) {
		Random random = new Random();
		long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * random.nextDouble());

		return (int) (fraction + aStart);
	}
}