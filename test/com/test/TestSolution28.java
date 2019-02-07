package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution28 {
    Solution28 solution28;

    @BeforeEach
    void setUp() throws Exception {
        solution28 = new Solution28();
    }

    @Test
    void testSimple() {
        assertEquals("I", solution28.intToRoman(1));
        assertEquals("V", solution28.intToRoman(5));
        assertEquals("X", solution28.intToRoman(10));
    }

    @Test
    void testWithComposite(){
        assertEquals("III", solution28.intToRoman(3));
        assertEquals("IV", solution28.intToRoman(4));
        assertEquals("VIII", solution28.intToRoman(8));
        assertEquals("IX", solution28.intToRoman(9));
    }

    @Test
    void testBigValue(){
        assertEquals("MCMXCIV", solution28.intToRoman(1994));
        assertEquals("LVIII", solution28.intToRoman(58));
    }

}
