package com.test;

import com.test.fundamental.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * i'm gonna explain how i can implement this code to solve.
 *
 * i'll walk through first before i solve this problem.
 *
 *   in this case
 *   For k = 2, you should return: 2->1->4->3->5
 *   while
 *      nth = 1;
 *      count = 0;
 *          index 0((nth*k)-k) <-> 1((nth*k)-1) : 2->1->3->4->5
 *          if count is same with (k/2)
 *              break;
 *      nth = 2;
 *      count = 0;
 *          index 2((nth*k)-k) <-> 3((nth*k)-1) : 2->1->4->3->5
 *          if count is same with (k/2)
 *              breka;
 *      if specific index is null, finish this while loop.
 *
 *   now i'm gonna walk through other case
 *
 *   For k = 3, 1->2->3->4->5->6->7, you should return: 3->2->1->6->5->4->7;
 *
 *   while
 *      nth = 1;
 *      count = 0;
 *          index 0(1 * 3 - 3) <-> 2(1 * 3 - 1) : 3->2->1->4->5->6->7;
 *          if count is same with (k/2)
 *              break;
 *      nth = 2;
 *      count = 0
 *          index 3(2 * 3 - 3) <-> 5(2 * 3 - 1) : 3->2->1->6->5->4->7;
 *          if count is same with (k/2)
 *              break;
 *
 *      if specific index is null, finish this while loop.
 *
 * other answer
 *
 * public ListNode reverseKGroup(ListNode head, int k) {
 *     ListNode curr = head;
 *     int count = 0;
 *     while (curr != null && count != k) { // find the k+1 node
 *         curr = curr.next;
 *         count++;
 *     }
 *     if (count == k) { // if k+1 node is found
 *         curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
 *         // head - head-pointer to direct part,
 *         // curr - head-pointer to reversed part;
 *         while (count-- > 0) { // reverse current k-group:
 *             ListNode tmp = head.next; // tmp - next head in direct part
 *             head.next = curr; // preappending "direct" head to the reversed list
 *             curr = head; // move head of reversed part to a new node
 *             head = tmp; // move "direct" head to the next node in direct part
 *         }
 *         head = curr;
 *     }
 *     return head;
 * }
 *
 * other answer2
 *
 * public class Solution {
 *         public ListNode reverseKGroup(ListNode head, int k) {
 *             if (head==null||head.next==null||k<2) return head;
 *
 *             ListNode dummy = new ListNode(0);
 *             dummy.next = head;
 *
 *             ListNode tail = dummy, prev = dummy,temp;
 *             int count;
 *             while(true){
 *                 count =k;
 *                 while(count>0&&tail!=null){
 *                     count--;
 *                     tail=tail.next;
 *                 }
 *                 if (tail==null) break;//Has reached the end
 *
 *
 *                 head=prev.next;//for next cycle
 *             // prev-->temp-->...--->....--->tail-->....
 *             // Delete @temp and insert to the next position of @tail
 *             // prev-->...-->...-->tail-->head-->...
 *             // Assign @temp to the next node of @prev
 *             // prev-->temp-->...-->tail-->...-->...
 *             // Keep doing until @tail is the next node of @prev
 *                 while(prev.next!=tail){
 *                     temp=prev.next;//Assign
 *                     prev.next=temp.next;//Delete
 *
 *                     temp.next=tail.next;
 *                     tail.next=temp;//Insert
 *
 *                 }
 *
 *                 tail=head;
 *                 prev=head;
 *
 *             }
 *             return dummy.next;
 *
 *         }
 *     }
 *
 */
class Solution42 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        int nth = 1;
        int count = 0;
        boolean state = true;

        Map<Integer, ListNode> map = new HashMap<>();
        //set list node data to map
        setMapFromListNode(head, map ,0);

        while(state){
            count = 0;
            for(int i = 0 ; i < (k/2) ; i++){
                // index 0((nth*k)-k) <-> 1((nth*k)-1) : 2->1->3->4->5
                if(!swap(map, nth*k-k+count, nth*k-1-count)){
                    state = false;
                    break;
                }
                count++;
            }
            nth++;
        }

        return map.get(0);
    }

    private void setMapFromListNode(ListNode head, Map<Integer, ListNode> map, int i) {
        if(head == null){
            return;
        }
        map.put(i, head);
        setMapFromListNode(head.getNext(), map, i+1);
    }

    private boolean swap(Map<Integer, ListNode> map, int i, int i1) {
        //if i1 is bigger than map size. we can't swap so this is wrong.
        if(map.size() <= i1){
            return false;
        }

        if(i + 1 == i1){
            ListNode beforeNode = map.get(i - 1);
            ListNode node1 =  map.get(i);
            ListNode node =  map.get(i1);
            ListNode afterNode = map.get(i1 + 1);

            if(i != 0){
                beforeNode.setNext(node);
                map.put(i - 1, beforeNode);
            }
            node.setNext(node1);
            node1.setNext(afterNode);


            map.put(i1, node1);
            map.put(i, node);
            map.put(i1 + 1, afterNode);

        }
        else{
            ListNode beforeNode = map.get(i - 1);
            ListNode node =  map.get(i1);
            ListNode afterNode = map.get(i + 1);

            ListNode beforeNode1 = map.get(i1 - 1);
            ListNode node1 =  map.get(i);
            ListNode afterNode1 = map.get(i1 + 1);


            if(i != 0){
                beforeNode.setNext(node);
                map.put(i - 1, beforeNode);
            }
            node.setNext(afterNode);
            map.put(i, node);

            beforeNode1.setNext(node1);
            node1.setNext(afterNode1);

            map.put(i1 -1, beforeNode1);
            map.put(i1, node1);
            map.put(i1 + 1, afterNode1);

        }


        return true;
    }

}