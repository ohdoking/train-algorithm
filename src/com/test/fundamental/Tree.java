package com.test.fundamental;

/**
 * 
 * 
 * Binary Tree Traversals
 * 
 * preorder(root, left, right)
 * 
 * inorder(left, root, right)
 * 
 * postorder(left, right, root)
 * @author ohdoking
 *
 */
public class Tree {
	
	public NodeInTree root;
	
	public int[] treeResult;
	private int index = 0;
	
	public Tree(int length) {
		treeResult = new int[length];
	}
	
	public NodeInTree init(int data, NodeInTree left, NodeInTree right) {
		return new NodeInTree(data, left, right);
	}
	
	public void setRootNode(NodeInTree root) {
		this.root = root;
	}

	public int[] inOrder() {
		inOrder(root);
		return treeResult;
	}
	

	public void inOrder(NodeInTree node) {
		
		if(node != null ) {
			inOrder(node.getLeft());
			treeResult[index++] = node.getData();
			inOrder(node.getRight());
		}
	}
	
	public int[] preOrder() {
		preOrder(root);
		return treeResult;
	}


	
	public void preOrder(NodeInTree node) {
		
		if(node != null ) {
			treeResult[index++] = node.getData();
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public int[] postOrder() {
		postOrder(root);
		return treeResult;
	}

	
	public void postOrder(NodeInTree node) {
		
		if(node != null ) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			treeResult[index++] = node.getData();
		}
	}
	
	
	
}
