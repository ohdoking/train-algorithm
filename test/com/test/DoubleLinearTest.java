package com.test;
import static org.junit.Assert.*;
import org.junit.Test;


public class DoubleLinearTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
 
    @Test
    public void test() {
        System.out.println("Fixed Tests dblLinear");
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);
             
    }
    @Test
    public void test2() {
    	//447 446, 3 / 2 -> 223  
    	//471 470  3 / 2 -> 235
    	//463 462  3 / 2 -> 231, 154
    	testing(DoubleLinear.dblLinear(100), 447);
    	
    }
}
