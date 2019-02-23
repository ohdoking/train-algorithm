package com.test;

import com.test.fundamental.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution42 {

    Solution42 solution42;

    @BeforeEach
    void setUp() {
        solution42 = new Solution42();
    }

    @Test
    public void test(){
        //For k = 2, you should return: 2->1->4->3->5
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.setNext(listNode5);
        listNode3.setNext(listNode4);
        listNode2.setNext(listNode3);
        listNode.setNext(listNode2);


        ListNode listNode1 = new ListNode(2);
        ListNode listNode1_2 = new ListNode(1);
        ListNode listNode1_3 = new ListNode(4);
        ListNode listNode1_4 = new ListNode(3);
        ListNode listNode1_5 = new ListNode(5);
        listNode1_4.setNext(listNode1_5);
        listNode1_3.setNext(listNode1_4);
        listNode1_2.setNext(listNode1_3);
        listNode1.setNext(listNode1_2);

        assertEquals(listNode1 ,solution42.reverseKGroup(listNode, 2));


    }

    @Test
    public void test2(){
        //For k = 2, you should return: 2->1->4->3->5
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.setNext(listNode5);
        listNode3.setNext(listNode4);
        listNode2.setNext(listNode3);
        listNode.setNext(listNode2);


        ListNode listNode1 = new ListNode(3);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(1);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_5 = new ListNode(5);
        listNode1_4.setNext(listNode1_5);
        listNode1_3.setNext(listNode1_4);
        listNode1_2.setNext(listNode1_3);
        listNode1.setNext(listNode1_2);

        assertEquals(listNode1 ,solution42.reverseKGroup(listNode, 3));


    }
}