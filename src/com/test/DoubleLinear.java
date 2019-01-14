package com.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * DoubleLinear
 * 
 * @author ohdoking
 * 
 *         Twice linear
 * 
 *         Consider a sequence u where u is defined as follows:
 * 
 *         The number u(0) = 1 is the first one in u. For each x in u, then y =
 *         2 * x + 1 and z = 3 * x + 1 must be in u too. There are no other
 *         numbers in u. Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27,
 *         ...]
 * 
 *         1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7
 *         gives 15 and 22 and so on...
 * 
 *         Task: Given parameter n the function dbl_linear (or dblLinear...)
 *         returns the element u(n) of the ordered (with <) sequence u.
 * 
 *         Example: dbl_linear(10) should return 22
 */
class DoubleLinear {

	public static int dblLinear(int n) {
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		
		int index = 0;
		while(index != n) {
			int value = list.get(index++);
			if(!list.contains(2 * value + 1)) {
				int tempIndex = getIndex(list, 2 * value + 1);
				list.add(tempIndex, 2 * value + 1);
			}
			if(!list.contains(3 * value + 1)) {
				int tempIndex = getIndex(list, 3 * value + 1);
				list.add(tempIndex, 3 * value + 1);
			}
			//Collections.sort(list);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray()[n];
	}
	
	private static int getIndex(List<Integer> list, int value) {
		for(int i = list.size() - 1 ; i >= 0; i--) {
			if(i == list.size() - 1 && list.get(i) < value) {
				return list.size();
			}
			else if(list.get(i) < value ) {
				return i + 1;
			}
		}
		return 0;
	}
}