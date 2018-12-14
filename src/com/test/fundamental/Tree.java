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
	
	/**
	 * Tree Traversals kinds
	 * 
	 */
	public enum TreeKind{
		Inorder, Preorder, Postorder
	}
	
	public NodeInTree root;
	
	public int[] treeResult;
	private int index = 0;
	private int nodeIndex = 0;
	
	/**
	 * node init
	 * 
	 * @param data
	 * @param left
	 * @param right
	 * @return
	 */
	public NodeInTree init(int data, NodeInTree left, NodeInTree right) {
		//when node add, nodeIndex count increase
		nodeIndex++;
		return new NodeInTree(data, left, right);
	}
	
	/**
	 * set root node in tree
	 * @param root
	 */
	public void setRootNode(NodeInTree root) {
		this.root = root;
	}

	public int[] order(TreeKind treeKind){
		treeResult = new int[nodeIndex];
		
		switch (treeKind) {
		case Inorder:
			inOrder(root);
			break;
		case Preorder:
			preOrder(root);
			break;
		case Postorder:
			postOrder(root);
			break;
		default:
			break;
		}
		
		return treeResult;
	}
	
	/**
	 * InOrder 
	 * @param node
	 */
	public void inOrder(NodeInTree node) {
		
		if(node != null ) {
			inOrder(node.getLeft());
			treeResult[index++] = node.getData();
			inOrder(node.getRight());
		}
	}
	
	/**
	 * PreOrder 
	 * @param node
	 */
	public void preOrder(NodeInTree node) {
		
		if(node != null ) {
			treeResult[index++] = node.getData();
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	/**
	 * PostOrder 
	 * @param node
	 */
	public void postOrder(NodeInTree node) {
		
		if(node != null ) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			treeResult[index++] = node.getData();
		}
	}
	
	
	
}
