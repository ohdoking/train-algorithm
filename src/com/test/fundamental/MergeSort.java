package com.test.fundamental;

import java.util.Arrays;
import java.util.Collections;

/**
 * Merge Sort
 *
 * @author ohdoking
 *
 * split array until becoming array length 2.
 *
 * and compair each value.
 *
 * device and conquer
 *
 */
public class MergeSort {
    public void sort(int[] arr) {

        int[] tmp = new int[arr.length];

        sort(arr, tmp, 0, arr.length - 1);
    }

    public void sort(int[] arr, int[] tmp, int start, int last){

        //if(last - start != 0){
        if(start < last){
            int mid = (start + last) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid + 1, last);
            merge(arr, tmp, start, mid, last);
        }

    }

    private void merge(int[] arr, int[] tmp, int start, int mid, int last) {
        for(int i = start ; i <= last; i++){
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while(part1 <= mid && part2 <= last){
            arr[index++] = tmp[part1] < tmp[part2] ? tmp[part1++] : tmp[part2++];
        }

        for(int i = index ; i <= last ; i++){
            arr[index++] = part1 <= mid ? tmp[part1++] : tmp[part2++];
        }
    }

    private void swap(int[] arr, int start, int last) {
        int temp = arr[last];
        arr[last] = arr[start];
        arr[start] = arr[last];
    }
}
