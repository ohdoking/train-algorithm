package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata4 {
	public static long nextBiggerNumber(long n) {

		List<Long> list = new ArrayList<Long>();

		// Permutations
		perm(list, String.valueOf(n).split(""), 0);

		List<Long> resultList = list
								.stream()
								.distinct()
								.sorted()
								.collect(Collectors.toList());

		// find param's position 
		int resultBeforeIndex = resultList.indexOf(n);
		
		return resultBeforeIndex + 1 > resultList.size() ? -1 : resultList.get(resultBeforeIndex + 1);
	}

	
	/**
	 * make Permutations  
	 * 
	 * @param list 
	 * @param arr
	 * @param pivot
	 */
	public static void perm(List<Long> list, String[] arr, int pivot) {

		if (pivot == arr.length) {
			list.add(Long.valueOf(String.join("", arr)));
		}

		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(list, arr, pivot + 1);
			swap(arr, i, pivot);
		}

	}

	public static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}