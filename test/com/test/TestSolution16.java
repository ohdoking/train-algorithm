package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.fundamental.ListNode;

class TestSolution16 {
	
	Solution16 solution16;
	
	ListNode listNode1;
	ListNode listNode2;
	/**
	 * 
	 * [2,4,3]
	 * [5,6,4]
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		solution16 = new Solution16(); 
		
		listNode1 = new ListNode(2);
		ListNode listNode12 = new ListNode(4);
		listNode12.setNext(new ListNode(3));
		listNode1.setNext(listNode12);
		
		
		listNode2 = new ListNode(5);
		ListNode listNode22 = new ListNode(6);
		listNode22.setNext(new ListNode(4));
		listNode2.setNext(listNode22);
	}

	@Test
	void test() {
		
		ListNode resultNode = new ListNode(7);
		ListNode resultNode22 = new ListNode(0);
		resultNode22.setNext(new ListNode(8));
		resultNode.setNext(resultNode22);
		
//		assertEquals(3, solution1.solution(1111));
//		assertEquals(0, solution1.solution(1));
		assertEquals(resultNode, solution16.addTwoNumbers(listNode1, listNode2));
	}

}
