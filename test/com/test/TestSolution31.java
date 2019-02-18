package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution31 {

    private Solution31 solution31;

    @BeforeEach
    void setUp() {
        solution31 = new Solution31();
    }

    @Test
    public void test(){
        //Input: "23"
        // * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

        List<String> list = new ArrayList<>();
        list.add("ad");
        list.add("ae");
        list.add("af");
        list.add("bd");
        list.add("be");
        list.add("bf");
        list.add("cd");
        list.add("ce");
        list.add("cf");

        assertEquals(list, solution31.letterCombinations("23"));

    }
}