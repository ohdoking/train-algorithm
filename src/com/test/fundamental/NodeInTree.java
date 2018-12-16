package com.test.fundamental;

public class NodeInTree {

	private int data;
	private NodeInTree left;
	private NodeInTree right;
	
	public NodeInTree(int data) {
		this.data = data;
	}
	
	public NodeInTree(int data, NodeInTree left, NodeInTree right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public NodeInTree getLeft() {
		return left;
	}
	public void setLeft(NodeInTree left) {
		this.left = left;
	}
	public NodeInTree getRight() {
		return right;
	}
	public void setRight(NodeInTree right) {
		this.right = right;
	}
}
