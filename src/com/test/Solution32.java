package com.test;

import com.test.fundamental.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 */
class Solution32 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new LinkedList<ListNode>();

        //set all link in list
        while(head.getNext() != null){
            list.add(head);
            head = head.getNext();
        }

        // link change
        ListNode nextNode = null;
        if(list.size() - n + 1 < list.size()){
            nextNode = list.get(list.size() - n + 1);
        }

        if(list.size() - n - 1 < 0){
            list.remove(0);
        }
        else {
            list.get(list.size() - n - 1).setNext(nextNode);
        }

        // return list head node
        return list.size() > 0 ? list.get(0) : null;
    }
}