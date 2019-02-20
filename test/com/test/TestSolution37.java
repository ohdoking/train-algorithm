package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution37 {
    Solution37 solution37;

    @BeforeEach
    void setUp() {
        solution37 = new Solution37();
    }

    @Test
    public void test(){
        assertEquals(2, solution37.strStr("hello", "ll"));
        assertEquals(-1, solution37.strStr("aaaaa", "bba"));
        assertEquals(4, solution37.strStr("mississippi", "issip"));
    }

    @Test
    public void whenInputEmptythenMinusOne(){
        assertEquals(0, solution37.strStr("", ""));
    }


}