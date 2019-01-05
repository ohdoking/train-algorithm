package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTrainComposition {

	TrainComposition tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new TrainComposition();
	}

	@Test
	void test() {
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        assertEquals(7, tree.detachWagonFromRight());
        assertEquals(13, tree.detachWagonFromLeft());
	}

}
