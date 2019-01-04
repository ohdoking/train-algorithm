package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMergeNames {

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
	        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
	        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
	        assertArrayEquals(new String[] {"Ava", "Emma", "Olivia", "Sophia"},MergeNames.uniqueNames(names1, names2));
	}

}
