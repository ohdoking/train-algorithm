package com.test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class Xbonacci {

	/**
	 * 
	 * @param signature 
	 * @param n Xbonacci length 
	 * @return
	 * 
		xbonacci {1,1,1,1} 10 = {1,1,1,1,4,7,13,25,49,94}
		xbonacci {0,0,0,0,1} 10 = {0,0,0,0,1,1,2,4,8,16}
		xbonacci {1,0,0,0,0,0,1} 10 = {1,0,0,0,0,0,1,2,3,6}
		xbonacci {1,1} produces the Fibonacci sequence
		
				assertArrayEquals(new double[] { 0, 0, 0, 0, 1, 1, 2, 4, 8, 16 },
				variabonacci.xbonacci(new double[] { 0, 0, 0, 0, 1 }, 10));
				
		assertArrayEquals(new double[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 },
				variabonacci.xbonacci(new double[] { 1, 1 }, 10));
	 */
  public double[] xbonacci(double[] signature, int n) {
      // hackonacci me
	  AtomicInteger nextId = new AtomicInteger(0);
	  
	  //@TODO signature length
	  /*IntStream
	  	.range(0, n)
	  	.mapToDouble((x)->{
	  		int index = nextId.getAndIncrement();
	  		if(signature.length > index ) {
	  			return signature[index];
	  		}
	  		
	  	});*/
	  
	  /*Double[] resultArray = Stream.iterate(signature, p -> new double[]{p[1], p[0] + p[1]})
	    .limit(n).toArray(Double[]::new);*/
	  Stream
			  .iterate(signature, p -> {
				  return dynamicArray(p);
				  //return new double[]{p[1], p[2], p[3], p[4], p[4] + p[3] + p[2] + p[1] + p[0]};
			  })
			  .limit(n + 1 - signature.length)
			  .mapToDouble(row -> row[signature.length-1])
			  .forEach(System.out::println);;
	  
	 //DoubleStream anStream = DoubleStream.of(signature).limit(signature.length-1);
	  
	  //DoubleStream resultStream = DoubleStream.concat(anStream, resultArray);
	    
//	  resultArray.forEach(System.out::println);
	  //return resultArray.toArray();
	  return new double[5];
	  
	  
  }
  
  private double[] dynamicArray(double[] array) {
	  AtomicInteger nextId = new AtomicInteger(0);
	  
	  DoubleStream resultStream = Stream
	  	.of(array)
	  	.map(x->{
	  		if(array.length == nextId.getAndIncrement()) {
	  			return DoubleStream.of(array).sum();
	  		}
	  		return array[nextId.get()];
	  	})
	  	.mapToDouble(x->x);
	  
	  return resultStream.toArray();
	  
  }
}