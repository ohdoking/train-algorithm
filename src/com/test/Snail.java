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
	
	enum Spin{
		RIGHT {
			@Override
			Spin changeNextState() {
				return Spin.DOWN;
			}

			@Override
			void movePosition(Point point) {
				point.setLocation(point.getX(), point.getY()+1);
			}
		}, DOWN {
			@Override
			Spin changeNextState() {
				return Spin.LEFT;
			}

			@Override
			void movePosition(Point point) {
				point.setLocation(point.getX()+1, point.getY());
				
			}
		}, LEFT {
			@Override
			Spin changeNextState() {
				return Spin.UP;
			}

			@Override
			void movePosition(Point point) {
				point.setLocation(point.getX(), point.getY()-1);
				
			}
		}, UP {
			@Override
			Spin changeNextState() {
				return Spin.RIGHT;
			}

			@Override
			void movePosition(Point point) {
				point.setLocation(point.getX()-1, point.getY());
				
			}
		};
		
		abstract Spin changeNextState();
		abstract void movePosition(Point point);
	}

    public static int[] snail(int[][] array) {
    	
    	int length = array[0].length;
    	
    	int[] result = new int[length * length];
    	//start is right way
    	Spin direction = Spin.RIGHT;
    	//start point is 0,0
    	Point point = new Point(0, 0);
    	int index = 0;
    	
    	// 3-5 , 4-7, 5-9, 6-11, 7-13
    	// array[0].length * 2 - 1 is circle spin count like above rule
    	for(int i = 0 ; i < array[0].length * 2 - 1; i++) {
    		//set snail length, decrease like blow rule
    		//[3 22 1 / 5 44 33 22 1]
    		if(i%2 == 1) {
    			length--;
    		}
    		
    		for(int j = 0 ; j < length; j++) {
    			result[index++] = array[point.x][point.y];
    			//if j is last length, it change direction
    			if(j == length - 1) {
    				direction = direction.changeNextState();
    			}
    			direction.movePosition(point);
    		}
    	}
    	return result;
   } 
}