package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
class TestSolution35 {
    Solution35 solution35;

    @BeforeEach
    void setUp() {
        solution35 = new Solution35();
    }

    /**
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     */
    @Test
    public void test(){
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> innerList = new ArrayList<>();
        innerList.add(7);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(2);
        innerList2.add(2);
        innerList2.add(3);

        list.add(innerList2);
        list.add(innerList);

        assertEquals(list, solution35.combinationSum(new int[]{2,3,6,7},7));
    }

    /**
     *
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     */
    @Test
    public void test2(){
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> innerList = new ArrayList<>();
        innerList.add(2);
        innerList.add(2);
        innerList.add(2);
        innerList.add(2);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(2);
        innerList2.add(3);
        innerList2.add(3);

        List<Integer> innerList3 = new ArrayList<>();
        innerList3.add(3);
        innerList3.add(5);

        list.add(innerList);
        list.add(innerList2);
        list.add(innerList3);


        assertEquals(list, solution35.combinationSum(new int[]{2,3,5},8));
    }

}