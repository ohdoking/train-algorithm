package com.test;

import java.util.List;

/**
 * You are given a list of trips that together form a journey from one place to another.
 * A trip has the form [starting place of the trip, destination place of the trip].
 * You are given the trips in random order.
 * Write a function to find out what is the starting place of the journey.
 * You may assume you are given the trips of the journey in a suitable data structure of your choice.
 * You may assume a place is represented by a string.
 *
 * Example 1:
 * exampleTrips := [[Cologne,Berlin],[Munich,Cologne],[YourPlace,Munich]]
 * The starting place of the journey given by exampleTrips is "YourPlace".
 *
 * Example 2:
 * exampleTrips := [ [A,B], [B,C], [C,D] ]
 * The trip in this example started at "A".
 *
 * Example 3:
 * exampleTrips := [ [D,E], [F,D], [E,X] ]
 * The trip in this example started at "F".
 *
 */
public class Solution23 {

	/**
	 * find a firstplace
	 * @param list
	 * @return
	 */
	public String findFirstPlace(List<String[]> list) {
		for(int i = 0 ; i < list.size(); i++) {
			//if i first place contain in second place, that isn't starting place
			if (containsPlace(list, list.get(i)[0])){
				return list.get(i)[0];
			}
		}
		return "";
		
	}
	/**
	 * check the contain place
	 * @param list
	 * @param firstPlace
	 * @return
	 */
	private boolean containsPlace(List<String[]> list, String firstPlace) {
		for(int i = 0 ; i < list.size(); i++) {
			//if i first place contain in second place, i return false 
			if(list.get(i)[1].equals(firstPlace)) {
				return false ;
			}
		}
		return true;
	}

}