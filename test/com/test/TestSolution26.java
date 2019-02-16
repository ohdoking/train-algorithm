package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSolution26 {
    Solution26 solution26;

    @BeforeEach
    void setUp() throws Exception {
        solution26 = new Solution26();
    }

    @Test
    void testSimple() {
        solution26.add("hi");
        solution26.add("hello");
        solution26.add("hey");
        //assertTrue(solution26.contains("hi"));
        assertTrue(solution26.contains("hello"));
        assertFalse(solution26.contains("helooo"));
    }
}
