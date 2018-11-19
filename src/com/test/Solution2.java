package com.test;
class Solution2 {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
    	return D!=0 ? (int) Math.ceil(((double)Y-X)/D) : 0;
    }
}