package com.test;

import java.util.stream.*;
import java.math.BigDecimal;

public class Xbonacci {

	/**
	 * 
	 * @param signature array value
	 * @param n         Xbonacci length
	 * @return
	 */
	public double[] xbonacci(double[] signature, int n) {
    if(n == 0){
      return new double[0];
    }
		DoubleStream resultArray = 
			Stream.iterate(signature, p -> {
				return dynamicArray(p);
			})
			.limit(n + 1 - signature.length)
			.mapToDouble(row -> row[signature.length - 1]);

		//basic array 
		DoubleStream anStream = DoubleStream.of(signature).limit(signature.length-1);
		//add two arrayStream
		DoubleStream resultStream = DoubleStream.concat(anStream, resultArray);

		return resultStream.toArray();

	}

	/**
	 * make new xbonacci array
	 * @param array
	 * @return
	 */
	private double[] dynamicArray(double[] array) {
		//double tempSum = DoubleStream.of(array).sum();
    //@fix when sum value is over **e16, sum result is wrong, so i used BigDecimal and converted.
    double tempSum = new BigDecimal(DoubleStream.of(array).sum()).doubleValue();
		for (int i = 0; i < array.length; i++) {
			if (array.length - 1 == i) {
				array[i] = tempSum;
			}
      else{
        array[i] = array[i + 1];
      }
		}
		return array;

	}
}