package com.test.fundamental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashTable {

    HashTable hashTable;
    @BeforeEach
    void setUp(){
        hashTable = new HashTable();
    }

    @Test
    void test() {

        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        assertEquals("20", hashTable.get("20"));
    }
}
