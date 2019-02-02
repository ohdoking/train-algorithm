package com.test.fundamental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinInHeap {

    MinInHeap minInHeap;

    @Before
    public void init(){
        minInHeap = new MinInHeap();
    }

    @Test
    public void test(){
        minInHeap.add(3);
        minInHeap.add(6);
        minInHeap.add(5);
        minInHeap.add(1);

        assertEquals(1, minInHeap.poll());
        assertEquals(3, minInHeap.poll());
        assertEquals(5, minInHeap.poll());
        assertEquals(6, minInHeap.poll());
    }

    @Test
    public void test2(){
        minInHeap.add(6);
        minInHeap.add(77);
        minInHeap.add(3);
        minInHeap.add(99);
        minInHeap.add(1);

        assertEquals(1, minInHeap.poll());
        assertEquals(3, minInHeap.poll());
        assertEquals(6, minInHeap.poll());
        assertEquals(77, minInHeap.poll());
        assertEquals(99, minInHeap.poll());
    }

    @Test
    public void testOver10Length(){
        minInHeap.add(6);
        minInHeap.add(77);
        minInHeap.add(3);
        minInHeap.add(99);
        minInHeap.add(1);
        minInHeap.add(6);
        minInHeap.add(77);
        minInHeap.add(3);
        minInHeap.add(99);
        minInHeap.add(1);
        minInHeap.add(6);
        minInHeap.add(77);
        minInHeap.add(3);
        minInHeap.add(99);
        minInHeap.add(1);

        assertEquals(1, minInHeap.poll());
        assertEquals(1, minInHeap.poll());
        assertEquals(1, minInHeap.poll());
        assertEquals(3, minInHeap.poll());
        assertEquals(3, minInHeap.poll());
        assertEquals(3, minInHeap.poll());
        assertEquals(6, minInHeap.poll());
        assertEquals(6, minInHeap.poll());
        assertEquals(6, minInHeap.poll());
        assertEquals(77, minInHeap.poll());
        assertEquals(77, minInHeap.poll());
        assertEquals(77, minInHeap.poll());
        assertEquals(99, minInHeap.poll());
        assertEquals(99, minInHeap.poll());
        assertEquals(99, minInHeap.poll());
    }
}
