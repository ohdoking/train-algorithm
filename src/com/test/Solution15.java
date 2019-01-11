package com.test;

import java.security.InvalidParameterException;

/**
 * 
 * Solution15
 * 
 * @author ohdoking
 * 
 * Street Fighter 2 - Character Selection
 * 
 * Selection cursor is circular horizontally but not vertically!
 * 
 * As you might remember from the game, the selection cursor rotates horizontally but not vertically; 
 * that means that if I'm in the leftmost and I try to go left again 
 * I'll get to the rightmost (examples: 
 * from Ryu to Vega, from Ken to M.Bison) and vice versa from rightmost to leftmost.
 * 
 * Instead, if I try to go further up from the upmost or further down from the downmost, 
 * I'll just stay where I am located (examples: you can't go lower than lowest row: 
 * Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the above image; 
 * you can't go upper than highest row: Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).

 */
public class Solution15 {
	public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {

		int x = position[0];
		int y = position[1];
		
		String[] arr = new String[moves.length];

		for (int i = 0; i < moves.length; i++) {
			String move = moves[i];
			
			
			switch (move) {
				case "up":
					y = y == 0 ? 0 : --y; 
					break;
				case "down":
					y = y == fighters.length - 1 ? fighters.length - 1 : ++y; 
					break;
				case "left":
					x = x == 0 ? fighters[0].length - 1 : --x; 
					break;
				case "right":
					x = x == fighters[0].length - 1 ? 0 : ++x; 
					break;
				default:
					throw new InvalidParameterException(move);
			}
			
			arr[i] = fighters[y][x];
			
		}
		return arr;
	}
}