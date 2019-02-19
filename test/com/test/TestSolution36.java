package com.test;

import com.test.fundamental.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution36 {

    Solution36 solution36;

    @BeforeEach
    void setUp() {
        solution36 = new Solution36();
    }

    @Test
    public void test(){

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.setNext(listNode4);
        listNode2.setNext(listNode3);
        listNode.setNext(listNode2);

        ListNode listNode1 = new ListNode(2);
        ListNode listNode12 = new ListNode(1);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode14 = new ListNode(3);
        listNode13.setNext(listNode14);
        listNode12.setNext(listNode13);
        listNode1.setNext(listNode12);

        assertEquals(listNode1, solution36.swapPairs(listNode));

    }

    @Test
    public void whenNullThenNull(){

        ListNode listNode = null;
        ListNode listNode1 = null;

        assertEquals(listNode1, solution36.swapPairs(listNode));

    }

    @Test
    public void whenOneNodeThenReturnOneNode(){

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);

        assertEquals(listNode1, solution36.swapPairs(listNode));

    }
}