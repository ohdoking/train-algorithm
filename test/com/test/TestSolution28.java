package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 */
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

    @Test
    void testReverse() {
        assertEquals(1, solution28.romanToInt("I"));
        assertEquals(5, solution28.romanToInt("V"));
        assertEquals(10, solution28.romanToInt("X"));
    }

    @Test
    void testWithCompositeReverse(){
        assertEquals(3, solution28.romanToInt("III"));
        assertEquals(4, solution28.romanToInt("IV"));
        assertEquals(8, solution28.romanToInt("VIII"));
        assertEquals(9, solution28.romanToInt("IX"));
    }

    @Test
    void testBigValueReverse(){
        assertEquals(1994, solution28.romanToInt("MCMXCIV"));
        assertEquals(58, solution28.romanToInt("LVIII"));
    }

}
