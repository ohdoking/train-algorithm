package com.test;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SumFct {
	public static BigInteger perimeter(BigInteger n) {
		
		return Stream
				.iterate(new BigInteger[] { BigInteger.ONE, BigInteger.ONE },
						p -> new BigInteger[] { p[1], p[0].add(p[1]) })
				.limit(n.intValue())//limit 
				.map(x -> x[1])
				.reduce((a, b) -> a.add(b)) // add whole value 
				.get() // get data
				.add(BigInteger.ONE) // first 
				.multiply(new BigInteger("4")); //each side multiply
	}
}