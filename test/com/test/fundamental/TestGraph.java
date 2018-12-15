package com.test.fundamental;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestGraph {

	Graph graph;
	
	@BeforeEach
	void setUp() throws Exception {
		
		/**
		 * 0
		 * |
		 * 1 -- 3 -- 5 -- 7
		 * |    |    |
		 * |    |    |
		 * 2 -- 4    6
		 *           |
		 *           |
		 *           8
		 * 
		 */
		
		int size = 9;
		
		graph = new Graph();
		
		NodeInGraph[] nodes = new NodeInGraph[size];
		for(int i = 0 ; i < size ; i++) {
			nodes[i] = new NodeInGraph(i);
		}
		graph.init(nodes);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 8);
		
	}

	@Test
	void testDFSStartAt0() {
		graph.setStartNode(0);
		assertArrayEquals(graph.dfs(), new int[] {0, 1, 3, 5, 7, 6, 8, 4, 2});
	}
	
	@Test
	void testDFSStartAt3() {
		graph.setStartNode(3);
		assertArrayEquals(graph.dfs(), new int[] {3, 5, 7, 6, 8, 4, 2, 1, 0});
	}
	
	@Test
	void testBFSStartAt0() {
		graph.setStartNode(0);
		assertArrayEquals(graph.bfs(), new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8});
	}
	
	@Test
	void testBFSStartAt3() {
		graph.setStartNode(3);
		assertArrayEquals(graph.bfs(), new int[] {3, 1, 2, 4, 5, 0, 6, 7, 8});
	}
	
	@Test
	void testBFSRStartAt0() {
		graph.setStartNode(0);
		assertArrayEquals(graph.bfsRecursive(), new int[] {0, 1, 2, 4, 3, 5, 6, 8, 7});
	}
	
	@Test
	void testBFSRStartAt3() {
		graph.setStartNode(3);
		assertArrayEquals(graph.bfsRecursive(), new int[] {3, 1, 0, 2, 4, 5, 6, 8, 7});
	}

}
