package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution39 {

    Solution39 solution39;

    @BeforeEach
    void setUp() {
        solution39 = new Solution39();
    }

    @Test
    public void test(){
        /**
         *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
         * Output:
         * [
         *   ["ate","eat","tea"],
         *   ["nat","tan"],
         *   ["bat"]
         * ]
         */
        List<List<String>> list = new ArrayList();
        List<String> innerList = new ArrayList<>();
        innerList.add("ate");
        innerList.add("eat");
        innerList.add("tea");
        List<String> innerList2 = new ArrayList<>();
        innerList2.add("nat");
        innerList2.add("tan");
        List<String> innerList3 = new ArrayList<>();
        innerList3.add("bat");

        list.add(innerList2);
        list.add(innerList3);
        list.add(innerList);

        assertEquals(list, solution39.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}