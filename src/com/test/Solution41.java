package com.test;

import com.test.fundamental.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * I'm gonna walk throught about this problem to solve .
 first of all,
 i'm gonna initialized the smallest value to compare array to merge.
 and result listNode to return.

 theSmallestValue;
 resultListNode;

 second i'm gonna find the smallest value via the whole arrays.
 i'll iterate using while loop until becoming every array is empty.

 i = 0
 1 , 1 , 2 -> 1 and remove that node in that array
 i = 1
 4, 1, 2 -> 1 ..
 i = 2
 4, 3, 2 -> 2 ..


 *
 */
class Solution41 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode resultListNode = null;
        ListNode firstListNode = null;
        int theSmallestValue = Integer.MAX_VALUE;
        Set emptyNodeSet = new HashSet();
        while(true){

            //init
            int theSmallestIndex = 0;
            theSmallestValue = Integer.MAX_VALUE;
            for(int i = 0 ; i < lists.length ; i++){
                if(lists[i] != null){
                    if(theSmallestValue >= lists[i].getVal()){
                        theSmallestValue = lists[i].getVal();
                        theSmallestIndex = i;
                    }
                }
                else{
                    emptyNodeSet.add(i);
                }

            }

            //remove node
            if(lists[theSmallestIndex] != null){
                lists[theSmallestIndex] = lists[theSmallestIndex].getNext();
            }
            if(resultListNode == null){
                resultListNode = new ListNode(theSmallestValue);
                firstListNode = resultListNode;
                System.out.println(theSmallestValue);
            }
            else{
                resultListNode.setNext(new ListNode(theSmallestValue));
                resultListNode = resultListNode.getNext();
            }
            if(emptyNodeSet.size() == lists.length - 1){
                break;
            }
        }
        return firstListNode;
    }
}