package com.test;

import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Palindrome {
    public static boolean isPalindrome(String word) {
    	String result = Stream
        		.of(word.split(""))
        		.map(e -> e.toLowerCase())
        		.collect(reverse())
        		.reduce("", String::concat);
    	
    	return word.toLowerCase().equals(result);
    }
    
    public static <T> Collector<T, ?, Stream<T>> reverse() {
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.reverse(list);
			return list.stream();
		});
	}
    
}