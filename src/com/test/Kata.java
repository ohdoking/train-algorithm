package com.test;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata {

  public static String high(String s) {
    // Your code here...
    
    String resultText = null;
		String[] splitted = s.split(" ");

		resultText = Stream
			.of(splitted)
			.max((aName, bName) -> aName.chars().map(x->x-96).sum() - bName.chars().map(x->x-96).sum())
			.get();
    
     
    return resultText;
  }

}