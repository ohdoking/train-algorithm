package com.test.fundamental;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author ohdoking
 *
 * @param <T>
 *
 *     partitioning
 */
public class QuickSort{

    public void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int last){

       int part = partition(arr, start ,last);

       if(start < part - 1){
           sort(arr, start, part - 1);
       }

       if(part < last){
           sort(arr, part, last);
       }
    }

    private int partition(int[] arr, int start, int last) {

        if(last - start == 0){
            return last;
        }

        int pivot = arr[(start+last)/2];

        while(start <= last){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[last] > pivot){
                last--;
            }
            if(start <= last){
                int temp = arr[last];
                arr[last] = arr[start];
                arr[start] = temp;
                start++;
                last--;
            }
        }

        return start;
    }
}
