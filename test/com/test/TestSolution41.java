package com.test;

import com.test.fundamental.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSolution41 {

    Solution41 solution41;

    @BeforeEach
    void setUp() {
        solution41 = new Solution41();
    }

    @Test
    public void test(){
        /**
         * Input:
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * Output: 1->1->2->3->4->4->5->6
          */

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode2.setNext(listNode3);
        listNode.setNext(listNode2);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode12 = new ListNode(3);
        ListNode listNode13 = new ListNode(4);
        listNode12.setNext(listNode13);
        listNode1.setNext(listNode12);

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(3);
        listNode2_1.setNext(listNode2_2);


    }
}