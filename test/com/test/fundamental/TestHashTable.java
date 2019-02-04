package com.test.fundamental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashTable {

    HashTable hashTable;
    @BeforeEach
    void setUp(){

    }

    @Test
    void testString() {
        HashTable<String, String> hashTable = new HashTable<String, String>();
        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        assertEquals("20", hashTable.get("20"));
    }

    @Test
    void testInteger() {
        hashTable = new HashTable<Integer, Integer>();
        // Put some key values.
        for(int i=0; i<30; i++) {
            hashTable.put(i, i);
        }

        assertEquals(20, hashTable.get(20));
    }

    @Test
    void testDouble() {
        HashTable<Double, Double> hashTable = new HashTable<Double, Double>();
        // Put some key values.
        for(int i=0; i<30; i++) {
            hashTable.put(Double.valueOf(i), Double.valueOf(i * 0.1));
        }

        assertEquals(0.2d, (double)hashTable.get(2d));
    }
}
