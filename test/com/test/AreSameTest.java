package com.test;
import static org.junit.Assert.*;
import org.junit.Test;


public class AreSameTest {

	@Test
	public void test1() {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testFalseCase() {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		int[] b = new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361};
		
		assertEquals(false, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testFalseCase2() {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		int[] b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};
		
		assertEquals(false, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testIncludeZero() {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11, 0};
		int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361, 0};
		
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testEmpty() {
		int[] a = new int[]{};
		int[] b = new int[]{};
		
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testIncludeOne() {
		int[] a = new int[]{1};
		int[] b = new int[]{1};
		
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	@Test
	public void testIncludeMinus() {
		int[] a = new int[]{-1,1,-10};
		int[] b = new int[]{100,1,1};
		
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	@Test
	public void test8() {
		int[] a = new int[]{-14,0,1,19,144,161,191,195};
		int[] b = new int[]{0, 1, 196, 361, 20736, 25921, 36481, 38025};
		
		assertEquals(true, AreSame.comp(a, b)); 
	}
	
	
	@Test
	public void test11() {
		assertEquals(false, AreSame.comp(new int[]{3, 10, 15}, new int[]{33, 99, 16*16}));
	}

	@Test
	public void test12() {
		assertEquals(false, AreSame.comp(new int[]{1, 3, 3, 9}, new int[]{11, 11, 77, 77}));
	}
}