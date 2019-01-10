package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * EnoughIsEnough
 * 
 * @author ohdoking
 *
 * Delete occurrences of an element if it occurs more than n times
 * 
 * Enough is enough!
 * 
 * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to show Charlie their entire collection. However, Charlie doesn't like this sessions, since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times. He tells them that he will only sit during the session if they show the same motive at most N times. Luckily, Alice and Bob are able to encode the motive as a number. Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?
 * 
 * Task
 * Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering. For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
 * 
 * Example
 * EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
 * EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
 * 
 */
public class EnoughIsEnough {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// deal with exceptions in case that is maxOccurrences == 0
		if(maxOccurrences != 0) {
			for(int i = 0 ; i < elements.length ; i++) {
				int temp = elements[i];
				if(map.get(temp) == null || map.get(temp) < maxOccurrences) {
					list.add(temp);
					map.put(temp, map.getOrDefault(temp, 0) + 1);
				}
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
		
	}

}