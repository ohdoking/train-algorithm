package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution30 {
    Solution30 solution30;

    @Before
    public void setUp() throws Exception {
        solution30 = new Solution30();
    }

    /**
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     *  A solution set is:
     *  [
     *    [-1, 0, 1],
     *    [-1, -1, 2]
     * ]
     *
     */
    @Test
    public void test(){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(-1);
        temp.add(-1);
        temp.add(2);
        list.add(temp);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(-1);
        temp2.add(0);
        temp2.add(1);
        list.add(temp2);

        assertEquals(list, solution30.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

}