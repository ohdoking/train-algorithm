package com.test;

import java.math.BigInteger;

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

		StringBuilder first = getNodeToString(l1);
		StringBuilder second = getNodeToString(l2);

		String result = new BigInteger(first.reverse().toString()).add(new BigInteger(second.reverse().toString())).toString();

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
	
	private StringBuilder getNodeToString(ListNode listNode) {
		
		StringBuilder text = new StringBuilder(); 
		boolean state = true;

		while (state) {
			if (listNode.getNext() != null) {
				text.append(listNode.getVal());
				listNode = listNode.getNext();
			} else {
				text.append(listNode.getVal());
				state = false;
			}
		}
		
		return text;
	}
}

