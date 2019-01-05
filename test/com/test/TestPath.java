package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPath {

	Path path;
	@BeforeEach
	void setUp() throws Exception {
		path = new Path("/a/b/c/d");
	}

	@Test
	void testSimple() {
        path.cd("../x");
        assertEquals("/a/b/c/x", path.getPath());
        
	}
	
	@Test
	void testMulti() {
		path.cd("../../x");
		assertEquals("/a/b/x", path.getPath());
		
	}
	
	@Test
	void testMulti2() {
		path.cd("../../x/y");
		assertEquals("/a/b/x/y", path.getPath());
		
	}

}
