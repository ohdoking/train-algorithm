package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCSTest {

    public LCS lcs;

    @BeforeEach
    public void init(){
        lcs = new LCS();
    }

    @Test
    public void test(){
        assertEquals(2, lcs.LCSLength("abc", "bc"));
    }
}
