package com.test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * Partition
 *
 * @author ohdoking
 *
 * Given a set of positive integers,
 * find if it can be divided into two subsets with equal sum.
 *
 * this qeustion is also kind of problem that i should use DP algorithm.
 *
 * basicially when i should repeat the same logic over and over again,
 * i should use DP algorithm
 *
 * this problem also use i should use specific value that is already calculated in.
 *
 * i'm gonna walk you through about this question.
 *
 * {1,2,3,6} -> true
 * {1,2,3} <-> {6} ; same sum;
 *
 *   1 2 3 6
 * 1 1
 * 2   1
 * 3     1
 * 6       1
 *
 *   1 2 3 6
 * 1 2 4 7 13
 * 2 4 8 15 28
 * 3 7 15 30 58
 * 6 13 28 58 70
 *
 * 1 236
 * 12 36
 * 123 6
 * 23 16
 *
 * 1 2 1 5 7
 *
 * 1 2157
 * 12 157
 * 121 57
 * 1215 7
 * 21 157
 * 215 17
 *
 *
 *
 */
public class Partition {

    public boolean partition(int[] arr) {

        //int[] DP = new int[];
        int totalSum = sum(arr);
        for(int i = 0 ; i < arr.length; i++){
            for(int j = i ; j < arr.length; j++){
                int[] temp = Arrays.copyOfRange(arr, i, j+1);
                int tempSum = sum(temp);
                if(tempSum == totalSum - tempSum){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean subSetSum(){
        return true;
    }

    private int sum(int[] arr){
        return Arrays.stream(arr).sum();
    }
}
