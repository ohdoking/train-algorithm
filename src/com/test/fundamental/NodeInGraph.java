package com.test.fundamental;

import java.util.LinkedList;

public class NodeInGraph {
	
	int data;
	LinkedList<NodeInGraph> adjacent;
	boolean marked;
	
	public NodeInGraph(int data) {
		this.data = data;
		this.marked = false;
		adjacent = new LinkedList<NodeInGraph>();
	}
	
	void addAdjacentNode(NodeInGraph node) {
		adjacent.add(node);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	

}
