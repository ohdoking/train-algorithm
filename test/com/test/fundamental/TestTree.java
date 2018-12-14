package com.test.fundamental;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.fundamental.Tree.TreeKind;

/**

 * 
 * @author ohdoking
 *
 */
class TestTree {
	Tree tree;
	
	@BeforeEach
	void setUp() throws Exception {
		
		/**
		 * 
		 * Test Tree Structure
		 * 
		 *     1
		 *   2     3
		 *  4 5
		 *  
		 */
		 tree = new Tree(5);
		 NodeInTree n4 = tree.init(4, null, null);
		 NodeInTree n5 = tree.init(5, null, null);
		 NodeInTree n2 = tree.init(2, n4, n5);
		 NodeInTree n3 = tree.init(3, null, null);
		 NodeInTree n1 = tree.init(1, n2, n3);
		 tree.setRootNode(n1);
		 
	}
	
	@Test
	void testInOrder() {
		assertArrayEquals(tree.order(TreeKind.Inorder), new int[] {4,2,5,1,3});
	}
	
	@Test
	void testPreOrder() {
		assertArrayEquals(tree.order(TreeKind.Preorder), new int[] {1,2,4,5,3});
	}
	
	@Test
	void testPostOrder() {
		assertArrayEquals(tree.order(TreeKind.Postorder), new int[] {4,5,2,3,1});
	}
	
	
	

}
