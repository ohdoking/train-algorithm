package com.test.fundamental;

public class BinarySearchTree {
	
	NodeInTree root;
	
	public NodeInTree search(NodeInTree root, int key) {
		if(root == null || root.getData() == key ) {
			return root;
		}
		if(root.getData() > key) {
			return search(root.getLeft(), key);
		}
		return search(root.getRight(), key);
		
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}

	private NodeInTree insert(NodeInTree root, int data) {
		if(root == null) {
			root = new NodeInTree(data);
			return root;
		}
		if(data < root.getData()) {
			root.setLeft(insert(root.getLeft(), data));
		}
		else if(data > root.getData()) {
			root.setRight(insert(root.getRight(), data));
		}
		
		return root;
	}
	
	public void delete(int data) {
		root = delete(root, data);
	}

	private NodeInTree delete(NodeInTree root, int data) {
		if(root == null) {
			return root;
		}
		if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		}
		else if(data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		}
		else {
			
			//no child
			if(root.getLeft() == null && root.getRight() == null) {
				return null;
			}
			//one children
			else if(root.getLeft() == null) {
				return root.getRight();
			}
			else if(root.getRight() == null) {
				return root.getLeft();
			}
			else {
				//two children
				root.setData(findMin(root.getRight()));
				root.setRight(delete(root.getRight(), root.getData()));
			}
		}
		
		return root;
	}

	private int findMin(NodeInTree root) {
		int min = root.getData();
		while(root.getLeft() != null) {
			min = root.getLeft().getData();
			root = root.getLeft();
		}
		return min;
	}
	
	
	

}
