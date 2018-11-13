package com.test;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author ohdoking
 *
 */
public class Max {
	public static int sequence(int[] arr) {
		// exception array length == 0 
		if (arr.length == 0) {
			return 0;
		}

		AtomicInteger index = new AtomicInteger(0);

		//make two dimensional to sum array from value of standard index 
		int[][] temp = 
				IntStream
					.of(arr)
					.boxed()
					.map(value -> makeSumArray(arr, index.getAndIncrement()))
					.toArray(int[][]::new);

		//find max value in sum two dimensional array
		OptionalInt result = 
				Stream
					.of(temp)
					.flatMapToInt(x -> Arrays.stream(x))
					.max();

		//result is negative retuen 0
		return result.orElse(0) > 0 ? result.orElse(0) : 0;
	}

	/**
	 * return sum array from value of standard index
	 * 
	 * @param arr array
	 * @param index standard index
	 * @return
	 */
	private static int[] makeSumArray(int[] arr, int index) {
		int[] sumArray = new int[arr.length];
		
		//standard index init
		sumArray[index] = arr[index];
		//make right side from standard index
		for (int i = index + 1; i < arr.length; i++) {
			sumArray[i] = sumArray[i - 1] + arr[i];
		}

		//make left side from standard index
		for (int i = index - 1; i >= 0; i--) {
			sumArray[i] = sumArray[i + 1] + arr[i];
		}

		return sumArray;
	}
}