package com.test.fundamental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestQuickSort {

    QuickSort quickSort;

    @BeforeEach
    void setUp(){
        quickSort = new QuickSort();
    }

    @Test
    void test() {
        int[] arr = new int[] {4,5,2,3,1};
        quickSort.sort(arr);
        assertArrayEquals(arr, new int[] {1,2,3,4,5});
    }

    @Test
    void testSameValue() {
        int[] arr = new int[] {4,1,3,3,3};
        quickSort.sort(arr);
        assertArrayEquals(arr, new int[] {1,3,3,3,4});
    }

}
