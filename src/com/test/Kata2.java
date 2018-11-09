package com.test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Kata2 {
	public static String expandedForm(int num) {
		// your code here
		String[] temp = Integer.toString(num).split("");
		AtomicInteger index = new AtomicInteger(temp.length);
		Optional<String> reduced = Stream
				.of(temp).map((x) -> String.valueOf(x))
				.reduce((s1, s2) -> {
					// reduce loop first time exception
					if (!s1.contains("+")) {
						if (!s2.equals("0")) {
							return addZero(index.getAndDecrement(), s1) + " + " + addZero(index.getAndDecrement(), s2);
						}
						return addZero(index.getAndDecrement(), s1);
					} else if (!s2.equals("0")) {
						return s1 + " + " + addZero(index.getAndDecrement(), s2);
					}
					// index decresement
					index.getAndDecrement();
					return s1;
				});

		return reduced.get();
	}

	public static String addZero(int index, String text) {
		return String.format("%1$-" + index + "s", text).replace(' ', '0');
	}
}