package com.test.fundamental;

import java.util.Arrays;

/**
 * MinInHeap
 *
 * @author ohdoking
 *
 * Heaps come in one of two forms, a min heap or max heap.
 * i've implemented min heap in this class using array.
 * Max heap is essentially the reverse.
 *
 */
public class MinInHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    /**
     * add element in array.
     * @param element
     */
    public void add(int element){
        ensureExtraCapacity();
        items[size++] = element;
        heapifyUp();
    }

    /**
     *  get the highest value in array
     */
    public int peek(){
        if(size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    /**
     * poll data in array
     * @return
     */
    public int poll(){
        if(size == 0){
            throw new IllegalStateException();
        }
        int item = peek();
        //Move the value of the last index to the first index.
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }


    /**
     *
     * heapify
     *
     */

    private void heapifyDown() {
        heapifyDown(0);
    }

    private void heapifyDown(int index){
        if(hasLeftChild(index) && items[index] > getLeftChild(index)){
            swap(index, getLeftChildIndex(index));
            heapifyDown(getLeftChildIndex(index));
        }

        if(hasRightChild(index) && items[index] > getRightChild(index)){
            swap(index, getRightChildIndex(index));
            heapifyDown(getRightChildIndex(index));
        }
    }

    private void heapifyUp() {
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index){
        if(hasParent(index) && items[index] < getParent(index)){
            swap(index, getParentIndex(index));
            heapifyUp(getParentIndex(index));
        }
    }

    /**
     * swap data in array
     * @param index
     * @param index2
     */
    public void swap(int index, int index2){
        int temp = items[index];
        items[index] = items[index2];
        items[index2] = temp;
    }

    /**
     * check the array size and extend capacity
     */
    public void ensureExtraCapacity(){
        if(size == capacity){
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    /**
     *
     * check tree(?)
     *
     */
    private int getLeftChildIndex(int parentIndex){
        return (2 * parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return (2 * parentIndex) + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex){
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex){
        return getParentIndex(childIndex) >= 0;
    }

    private int getLeftChild(int parentIndex){
        return items[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex){
        return items[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex){
        return items[getParentIndex(childIndex)];
    }

}
