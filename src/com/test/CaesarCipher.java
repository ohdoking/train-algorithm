package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * CaesarCipher
 * 
 * @author ohdoking
 *
 * The action of a Caesar cipher is to replace each plaintext letter 
 * with a different one a fixed number of places up or down the alphabet.
 * 
 * This program performs a variation of the Caesar shift. 
 * The shift increases by 1 for each character (on each iteration).
 * 
 * 
 */
public class CaesarCipher {
	
	enum Mode{
		MOVING, DEMOVOING,  
	}
	
	public static List<String>  movingShift(String s, int shift) {
		//65 A 90 Z
		//97 a 122 z
		
		int split = 5;
		
		char[] stringArray = shiftString(s, shift , Mode.MOVING);
		
		
		List<String> list = new ArrayList<String>();
		int lenght = stringArray.length / split + 1;
		for(int i = 0 ; i < split ; i ++) {
			if(i + 1 == split) {
				list.add(new String(stringArray, lenght * i, stringArray.length - lenght * i));
			}
			else {
				list.add(new String(stringArray, lenght * i, lenght));
			}
		}
		
		return list;
	}
	
	public static String demovingShift(List<String> s, int shift) {
		String totalText = "";
		for(String text : s) {
			totalText = totalText.concat(text);
		}
		
		char[] stringArray = shiftString(totalText, shift, Mode.DEMOVOING);
		
		return new String(stringArray);
		
	}
	
	private static char[] shiftString(String text, int shift, Mode mode) {
		char[] stringArray = text.toCharArray();
		
		for(int i = 0 ; i < stringArray.length ; i++) {
			char tempChar = stringArray[i];
			int ascii = (int) tempChar;
			
			int start = 0;
			int last = 0;
			
			if(Character.isUpperCase(tempChar)) {
				start = 65;
				last = 90;
			}
			else {
				start = 97;
				last = 122;
			}
			
			
			/**
			 * exception 
			 */
			//if shift is over ascii code gap, shift init
			if(shift > last - start + 1) {
				shift = 1;
			}
			//if tempChar isn't char, just increase shift and continue;
			if(!Character.isAlphabetic(tempChar)) {
				shift++;
				continue;
			}
			
			//seperate Mode
			switch (mode) {
				case MOVING:
					
					if(ascii + shift > last) {
						ascii += (shift++ - (last - start + 1)); 
					}
					else {
						ascii += (shift++);
					}
					
					break;
				case DEMOVOING:
					
					if(ascii - shift < start) {
						ascii -= (shift++ - (last - start + 1)); 
					}
					else {
						ascii -= (shift++);
					}
					
					break;
			}
			
			stringArray[i] = (char)ascii;
		}
		
		return stringArray;
	}
}