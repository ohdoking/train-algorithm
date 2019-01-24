package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionTest {

    Partition partition;

    @BeforeEach
    void setUp() throws Exception {
        partition = new Partition();
    }

    @Test
    void test() {
        boolean sum = false;
        int x = 1;
        System.out.println(sum & x > 0);
        System.out.println(sum && x > 0);
        //1,8,5 - 7,3,4
        assertEquals(true, partition.partition(new int[]{ 7, 3, 1, 5, 4, 8 }));
        assertEquals(true, partition.partition(new int[]{ 3, 1, 1, 2, 2, 1 }));
    }
}
