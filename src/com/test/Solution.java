package com.test;

//you can also use imports, for example:
import java.util.*;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.stream.Collectors;
//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8

		List<Integer> resultList = Arrays
				.stream(A)
				.boxed()
				.filter(x -> x > 0)
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		int smallestValue = 0;

		if (resultList.size() == 0) {
			smallestValue = 1;
		} else if (resultList.size() == 1) {
			smallestValue = resultList.get(0) + 1;
		} else {
			for (int i = 0; i < resultList.size(); i++) {
				if (resultList.size() == i + 1) {
					smallestValue = resultList.get(i) + 1;
					break;
				} else if (resultList.get(i) + 1 == resultList.get(i + 1)) {
					continue;
				}
				smallestValue = resultList.get(i) + 1;
				break;

			}
		}

		return smallestValue;

	}
}