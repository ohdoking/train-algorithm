package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution33 {
    Solution33 solution33;

    @BeforeEach
    void setUp() {
        solution33 = new Solution33();
    }

    @Test
    public void test(){
        assertTrue(solution33.isValid("{[]}"));
        assertTrue(solution33.isValid("()"));
        assertTrue(solution33.isValid("()[]{}"));
        assertFalse(solution33.isValid("(]"));
        assertFalse(solution33.isValid("([)]"));
    }

    @Test
    public void whenNullThenTrue(){
        assertTrue(solution33.isValid(""));
    }

    @Test
    public void whenCloseBracketThenFalse(){
        assertFalse(solution33.isValid("]"));
    }

}