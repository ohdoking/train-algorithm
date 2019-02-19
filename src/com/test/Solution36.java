package com.test;

import com.test.fundamental.ListNode;

/**
 *
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
class Solution36 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.getNext() == null){
            return null;
        }
        ListNode headNode = head.getNext();
        ListNode previousNode = null;
        while(true){
            if(head != null && head.getNext() != null){
                ListNode tempNode = head.getNext();
                ListNode nextNode = head.getNext().getNext();
                head.setNext(nextNode);
                tempNode.setNext(head);
                if(previousNode != null){
                    previousNode.setNext(tempNode);
                }
                previousNode = head;
                head = head.getNext();
            }
            else{
                break;
            }
        }
        return headNode;
    }
}