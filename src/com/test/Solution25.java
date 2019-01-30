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
 * at this time time complex is O(n^2) and space complex is also O(n^2)
 *
 * so i want to find more nice solution about this question .
 *
 * first of all, i'm gonna implement using my first idea.
 *
 * this isn't work when height length has a lot of values
 *
 * so i need to find much better solution.
 *
 *
 *
 */
class Solution25 {
    public int maxArea(int[] height) {
        int theHighestArea = 0;
        for(int i = 0 ; i < height.length ; i++){
            for (int j = i+1 ; j < height.length; j++){
                theHighestArea = Math.max(theHighestArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return theHighestArea;
    }
}