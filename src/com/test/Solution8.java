package com.test;

import java.util.Arrays;

class Solution8 {
	public String solution(int[] T) {
	    // write your code in Java SE 8
		
		String[] season = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
		
		int eachSeasonDay = T.length/4;
		int highestAmplitude = 0;
		String highestAmplitudeSeason = "";
		
		for(int i = 0; i < 4; i++) {
			
			int[] tempArray = Arrays.copyOfRange(T, i*eachSeasonDay, (i+1)*eachSeasonDay);
			Arrays.sort(tempArray); 
			
			int tempAmplitude = tempArray[tempArray.length-1] - tempArray[0];
			if(highestAmplitude < tempAmplitude) {
				highestAmplitude = tempAmplitude;
				highestAmplitudeSeason = season[i];
			}
			
		}
		
		return highestAmplitudeSeason;
    }
}