package com.test;

/**
 * Median of Two Sorted Arrays
 * 
 * @author ohdoking
 *
 *         There are two sorted arrays nums1 and nums2 of size m and n
 *         respectively.
 * 
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 * 
 *         You may assume nums1 and nums2 cannot be both empty.
 *         
 *         
 *         I'm gonna explain my solution to you first
 *         
 *         they are already sorted value like this question said eariler 
 *         
 *         first of all i'm gonna make one array using this two sorted array.
 *         
 *         and i'll get a middle value 
 *         
 *         if this array is odd, i just get a middle value, 
 *         but this array length is even, i'll get two of middle value.
 *         
 *         
 *         
 *         
 */
class Solution18 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int[] nums3 = new int[nums1.length + nums2.length];
		double result = 0;
		
		int a = 0;
		int b = 0;
		
		//make one array
		for(int i = 0 ; i < nums3.length ; i++) {
			if(b == nums2.length) {
				nums3[i] = nums1[a++];
			}
			else if(a == nums1.length){
				nums3[i] = nums2[b++];
			}
			else {
				if(nums1[a] < nums2[b]) {
					nums3[i] = nums1[a++];
				}
				else {
					nums3[i] = nums2[b++];
				}
			}
		}
		
		
		if(nums3.length%2 == 0) {
			result = (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2])/2.0; 
		}
		else {
			result = nums3[nums3.length / 2];
		}
		
		return result;
	}
}