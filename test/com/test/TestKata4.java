package com.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestKata4 {
    @Test
    public void basicTests() {
         assertEquals(21, Kata4.nextBiggerNumber(12));
         assertEquals(531, Kata4.nextBiggerNumber(513));
         assertEquals(2071, Kata4.nextBiggerNumber(2017));
         assertEquals(441, Kata4.nextBiggerNumber(414));
         assertEquals(414, Kata4.nextBiggerNumber(144));
         assertEquals(414444444, Kata4.nextBiggerNumber(144444444));
         
    }      
}