package com.test.fundamental;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph
 * 
 *  Graph characteristic
 *  
 * 	1. Directed
 * 		- Arrangement makes no difference and thus it is an unordered pair.
 *  2. Undirected
 *  	- directed graphs have some order to the relations
 *  	- weighted graph if a number(weight) is assigned to each edge
 *  
 *  Graph type(?)
 *  
 *  1. cyclic
 *  2. acyclic
 *  
 *  How to Express Graphs
 *  
 *  1. Adjacency(인접) Matrix
 *  2. Adjacency List
 *  
 *  DFS(Depth First Search)
 *  	- Goes DEEP(to children) before going broad(to neighbors)
 *  	- recursive or stack
 *  BFS(Breadth First Search)
 *  	- Goes BROAD(to neighbors) before going deep(to children)
 *  	- iterative, using queue
 *
 * @author ohdoking
 *
 */
public class Graph {

	NodeInGraph[] nodes;
	
	int[] graphOrderResult;
	NodeInGraph startNode;
	
	boolean flag = true;
	int index = 0;
	
	public void init(NodeInGraph[] nodes) {
		this.nodes = nodes;
		graphOrderResult = new int[nodes.length];
	}
	
	public void setStartNode(int index) {
		this.startNode = nodes[index];
	}
	
	void addEdge(int i1, int i2) {
		NodeInGraph n1 = nodes[i1];
		NodeInGraph n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.addAdjacentNode(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.addAdjacentNode(n1);
		}
	}

	public int[] dfs() {
		dfs(startNode);
		return graphOrderResult;
	}
	
	public void dfs(NodeInGraph node) {
		Stack<NodeInGraph> stack = new Stack<NodeInGraph>();
		stack.push(node);
		node.setMarked(true);
		
		while(!stack.isEmpty()) {
			NodeInGraph popNode = stack.pop();
			
			for(NodeInGraph temp : popNode.adjacent) {
				if(!temp.isMarked()) {
					stack.push(temp);
					temp.setMarked(true);
				}
			}
			graphOrderResult[index++] = popNode.getData();
			
		}

	}
	
	public int[] bfs() {
		bfs(startNode);
		return graphOrderResult;
	}

	public void bfs(NodeInGraph node) {
		Queue<NodeInGraph> queue = new LinkedList<NodeInGraph>();
		queue.add(node);
		node.setMarked(true);
		while(!queue.isEmpty()) {
			NodeInGraph popNode = queue.poll();
			for(NodeInGraph temp : popNode.adjacent) {
				if(!temp.isMarked()) {
					queue.add(temp);
					temp.setMarked(true);
				}
			}
			graphOrderResult[index++] = popNode.getData();
		}
	}

	
	public int[] bfsRecursive() {
		bfsRecursive(startNode);
		return graphOrderResult;
	}
	
	
	public void bfsRecursive(NodeInGraph node) {
		if(node == null) {
			return;
		}
		graphOrderResult[index++] = node.getData();
		node.setMarked(true);
		for(NodeInGraph temp : node.adjacent) {
			if(!temp.isMarked()) {
				bfsRecursive(temp);
			}
		}
	}
	
}
