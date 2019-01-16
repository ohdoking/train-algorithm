package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Rainfall
 * 
 * @author ohdoking
 *
 *         Rainfall
 * 
 *         data and data1 are two strings with rainfall records of a few cities
 *         for months from January to December. The records of towns are
 *         separated by \n. The name of each town is followed by :.
 * 
 *         data and towns can be seen in "Your Test Cases:".
 * 
 *         Task: 
 *         - function: mean(town, strng) should return the average of
 *         rainfall for the city town and the strng data or data1 (In R and
 *         Julia this function is called avg). 
 *         - function: variance(town, strng)
 *         should return the variance of rainfall for the city town and the
 *         strng data or data1. 
 *         
 *         Examples: 
 *         	mean("London", data), 51.19(9999999999996) 
 *          variance("London", data), 57.42(833333333374)
 *         
 *         Notes: 
 *         - if functions mean or variance have as parameter town a city
 *         which has no records return -1 or -1.0 (depending on the language)
 *         - Don't truncate or round: the tests will pass if abs(your_result -
 *         test_result) <= 1e-2 or abs((your_result - test_result) /
 *         test_result) <= 1e-6 depending on the language. 
 *         - Shell tests only variance 
 *         - A ref:
 *         	http://www.mathsisfun.com/data/standard-deviation.html 
 *         - data and data1
 *         (can be named d0 and d1 depending on the language; see "Sample
 *         Tests:") are adapted from: http://www.worldclimate.com
 */
public class Rainfall {

	public static double mean(String town, String strng) {
		double[] monthRainFall = getMonthRainFallByTown(town, strng);
		return monthRainFall == null ? -1 : mean(monthRainFall);
	}

	public static double variance(String town, String strng) {
		double[] monthRainFall = getMonthRainFallByTown(town, strng);
		return monthRainFall == null ? -1 : variance(monthRainFall);
	}
	
	private static double[] getMonthRainFallByTown(String town, String strng) {
		List<CityRainFall> list = parsingData(strng);
		for(CityRainFall cityRainFall : list) {
			if(cityRainFall.getName().equals(town)) {
				return cityRainFall.getMonthRainFall();
			}
		}
		return null;
	}
	
	/**
	 * data parsing and make DO
	 * 
	 * data format : 
	 * 
	 * "Rome:Jan 90.2,Feb 73.2,Mar 80.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 147.7,Nov 121.0,Dec 97.9" +
	 * "\n" +
	 * "London:Jan 58.0,Feb 38.9,Mar 49.9,Apr 42.2,May 67.3,Jun 52.1,Jul 59.5,Aug 77.2,Sep 55.4,Oct 62.0,Nov 69.0,Dec 52.9" +
	 * "\n" +
	 * "Paris:Jan 182.3,Feb 120.6,Mar 188.1,Apr 204.9,May 323.1,Jun 350.5,Jul 336.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7" +
	 * 
	 * @param data
	 * @return
	 */
	public static List<CityRainFall> parsingData(String data){
		List<CityRainFall> list = new ArrayList<CityRainFall>();

		String[] splitData = data.split("\\n");
		
		for(int i = 0 ; i < splitData.length ; i++) {
			CityRainFall cityRainFall = new CityRainFall(); 
			String city = splitData[i].split(":")[0];
			String[] arr = splitData[i].split(":")[1].split(",");
			
			cityRainFall.setName(city);
			
			double[] tempArr = new double[12];
			for(int j = 0 ; j < arr.length ; j++) {
				tempArr[j] = Double.valueOf(arr[j].split(" ")[1]).doubleValue();
			}
			cityRainFall.setMonthRainFall(tempArr);
			list.add(cityRainFall);
		}
        
        return list;
		
	}
	/**
	 * getMean
	 * @param data
	 * @return
	 */
	public static double mean(double[] data) {
        double sum = 0.0;
        for(double a : data) {
        	sum += a;
        }
        return sum/data.length;
    }
	/**
	 * getVariance(분산)
	 * @param data
	 * @return
	 */
	public static double variance(double[] data) {
        double mean = mean(data);
        double temp = 0;
        for(double a :data) {
        	temp += (a-mean)*(a-mean);
        }
        return temp/(data.length);
    }
	
}

class CityRainFall{
	private String name;
	private double[] monthRainFall = new double[12];
	
	public String getName() {
		return name;
	}
	public double[] getMonthRainFall() {
		return monthRainFall;
	}

	public void setMonthRainFall(double[] monthRainFall) {
		this.monthRainFall = monthRainFall;
	}

	public void setName(String name) {
		this.name = name;
	}
}