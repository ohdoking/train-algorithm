package com.test;

/**
 * Container With Most Water
 *
 * @author ohdoking
 *
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 * i've just finished read this question.
 * and i came up with simple idea that
 * calculate area each every case and return the highest area.
 * at this time time complex is O(n^2) and space complex is O(1)
 *
 * so i want to find more nice solution about this question .
 *
 * first of all, i'm gonna implement using my first idea.
 *
 * this isn't work when height length has a lot of values
 *
 * so i need to find much better solution.
 *
 * using the two point.
 * i'm gonna check the each start and end point
 * we take a two pointer, one at the beginning and one at the end of array costituting the lenght of lines.
 * after calculating the first value and last value area then move the lower height pointer.
 *
 * and when the last index is less than the first index, end the while loop
 *
 *
 */
class Solution25 {
    /**
     * first solution
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int theHighestArea = 0;
        for(int i = 0 ; i < height.length ; i++){
            for (int j = i+1 ; j < height.length; j++){
                theHighestArea = Math.max(theHighestArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return theHighestArea;
    }

    /**
     * second solution
     */
    public int maxArea(int[] height) {
        int theHighestArea = 0;
        int start = 0;
        int last = height.length - 1;

        while(start < last){
            theHighestArea = Math.max(Math.min(height[start], height[last]) * (last - start),theHighestArea);
            if(height[start] < height[last]){
                start++;
            }
            else{
                 last--;
            }
        }

        return theHighestArea;
    }



}