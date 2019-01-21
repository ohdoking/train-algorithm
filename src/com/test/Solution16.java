package com.test;

import com.test.fundamental.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * // i'm gonna reverse input value for making result.
 * 
 * and then i'm gonna make own number for adding.
 * 
 * and i'm gonna add both input and i'm gonna seperate each position value.
 * 
 */
class Solution16 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		StringBuilder first = new StringBuilder();
		StringBuilder second = new StringBuilder();

		boolean state = true;

		while (state) {
			if (l1.getNext() != null) {
				first.append(l1.getVal());
				l1 = l1.getNext();
			} else {
				first.append(l1.getVal());
				state = false;
			}
		}

		state = true;

		while (state) {
			if (l2.getNext() != null) {
				second.append(l2.getVal());
				l2 = l2.getNext();
			} else {
				second.append(l2.getVal());
				state = false;
			}
		}

		first.reverse();
		second.reverse();

		String result = String.valueOf(Integer.valueOf(first.toString()) + Integer.valueOf(second.toString()));

		char[] arr = result.toCharArray();
		ListNode listNode = setListNode(null, 0, arr);
		
		return listNode;

	}
	
	private ListNode setListNode(ListNode listNode, int index , char[] arr) {
		if(arr.length == index) {
			return null;
		}
		listNode = new ListNode(Character.getNumericValue(arr[arr.length - index - 1])); 
		listNode.setNext(setListNode(listNode, index + 1, arr));
		return listNode;
	}
}

