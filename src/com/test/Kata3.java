package com.test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Kata3 {
	public static double findUniq(double arr[]) {
		// after calculating frequency, make map
		// return the lowest frequency key
		return Arrays
				.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .findFirst()
		        .get()
		        .getKey();
	}
}