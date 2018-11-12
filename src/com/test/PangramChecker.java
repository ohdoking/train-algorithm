package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class PangramChecker {

	public boolean check(String sentence) {

		//initialize to ascii code a = 97 
		AtomicInteger compare = new AtomicInteger(97);

		boolean result = true;
		try{
			sentence
			.toLowerCase()
			.chars()
			.distinct()// remove duplicate
			.filter(x -> Character.isLetter(x)) // if param isn't character, remove.
			.sorted()// order
			.forEach(x -> {
				// compare 97:a -> 122:z
				if (x != compare.getAndIncrement()) {
					//Change the data value by generating an runtime error.
					throw new RuntimeException();
				}
			});
		}
		catch (RuntimeException e) {
			result = false;
		}

		return result;
	}
}