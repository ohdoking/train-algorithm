package com.test;

import java.awt.Point;

/**
 * Snail
 * 
 * @author ohdoking
 *
 *	Snail Sort
 *
 *	Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
 *	
 *	array = [[1,2,3],
 *			[4,5,6],
 *			[7,8,9]]
 *
 *	snail(array) #=> [1,2,3,6,9,8,7,4,5]
 *
 *	For better understanding, please follow the numbers of the next array consecutively:
 *	
 *	array = [[1,2,3],	
 *			[8,9,4],
 *			[7,6,5]]
 *
 *	snail(array) #=> [1,2,3,4,5,6,7,8,9]
 *	
 *	NOTE: The idea is not sort the elements from the lowest value to the highest; 
 *		  the idea is to traverse the 2-d array in a clockwise snailshell pattern.
 *	
 *	NOTE 2: The 0x0 (empty matrix) is represented as [[]]
 */
public class Snail {

    public static int[] snail(int[][] array) {
    	
    	int[] result = new int[array[0].length * array[0].length];
    	if(array[0].length == 0) {
    		return result;
    	}
    	int index = 0;
    	Point point = new Point(0, 0);
    	int direction = 0;
    	// 0 : right > 1 : down > 2 : left > 3 : up
    	int length = array.length;
    	// 3-5 , 4-7, 5-9, 6-11
    	for(int i = 0 ; i < array.length * 2 - 1; i++) {
    		//set snail length
    		if(i%2 == 1) {
    			length--;
    		}
    		
    		for(int j = 0 ; j < length; j++) {
    			result[index++] = array[point.x][point.y];
    			//set direction
    			if(j == length - 1) {
    				direction = (i + 1) % 4;
    			}
    			switch (direction) {
    			//right
    			case 0:
    				point.setLocation(point.getX(), point.getY()+1);
    				break;
    				//down
    			case 1:
    				point.setLocation(point.getX()+1, point.getY());
    				break;
    				//left
    			case 2:
    				point.setLocation(point.getX(), point.getY()-1);
    				break;
    				//up
    			case 3:
    				point.setLocation(point.getX()-1, point.getY());
    				break;
    				
    			default:
    				break;
    			}
    			
    			
    		}
    		
    	}
    	return result;
   } 
}