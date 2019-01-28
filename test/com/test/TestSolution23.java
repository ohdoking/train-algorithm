package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestSolution23 {

	private Solution23 solution23;

	@BeforeEach
	void setUp() throws Exception {
		solution23 = new Solution23();
	}

	@Test
	void test(){
		
		List<String[]> list = new ArrayList<>();
		
		//[[Cologne,Berlin],[Munich,Cologne],[YourPlace,Munich]]
		list.add(new String[] {"Cologne","Berlin"});
		list.add(new String[] {"Munich","Cologne"});
		list.add(new String[] {"YourPlace","Munich"});
		
		assertEquals("YourPlace", solution23.findFirstPlace(list));
		assertEquals("YourPlace", solution23.findFirstPlace1(list));
		
		
	}
	
	@Test
	void test2(){
		
		List<String[]> list = new ArrayList<>();
		
		//[ [A,B], [B,C], [C,D] ]
		list.add(new String[] {"A","B"});
		list.add(new String[] {"B","C"});
		list.add(new String[] {"C","D"});
		
		assertEquals("A", solution23.findFirstPlace(list));
		assertEquals("A", solution23.findFirstPlace1(list));
		
	}
	
	@Test
	void test3(){
		
		List<String[]> list = new ArrayList<>();
		
		//[ [A,B], [B,C], [C,D] ]
		list.add(new String[] {"D","E"});
		list.add(new String[] {"F","D"});
		list.add(new String[] {"E","X"});
		
		assertEquals("F", solution23.findFirstPlace(list));
		assertEquals("F", solution23.findFirstPlace1(list));
		
	}
	

}
