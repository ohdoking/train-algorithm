package com.test;

import java.util.*;

/**
 * You are given a list of trips that together form a journey from one place to another.
 * A trip has the form [starting place of the trip, destination place of the trip].
 * You are given the trips in random order.
 * Write a function to find out what is the starting place of the journey.
 * You may assume you are given the trips of the journey in a suitable data structure of your choice.
 * You may assume a place is represented by a string.
 *
 * Example 1:
 * exampleTrips := [[Cologne,Berlin],[Munich,Cologne],[YourPlace,Munich]]
 * The starting place of the journey given by exampleTrips is "YourPlace".
 *
 * Example 2:
 * exampleTrips := [ [A,B], [B,C], [C,D] ]
 * The trip in this example started at "A".
 *
 * Example 3:
 * exampleTrips := [ [D,E], [F,D], [E,X] ]
 * The trip in this example started at "F".
 *
 */
public class Solution23 {
	/**
	 *
	 * ----------------------------------- solution 1 start ---------------------------------------------
	 *
	 */
	class Graph{
		String name;
		Graph nextDestination;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Graph getNextDestination() {
			return nextDestination;
		}

		public void setNextDestination(Graph nextDestination) {
			this.nextDestination = nextDestination;
		}

	}
	public String findFirstPlace1(List<String[]> list){

		/**
		 * set graph from list
		 */
		Set<Graph> gSet = new HashSet<>();
		for(String[] data : list){
			Graph g = null;
			Graph g2 = null;
			for(Graph graph : gSet){
				if(graph.getNextDestination() != null){
					if(data[0].equals(graph.getNextDestination().getName())){
						g = graph;
					}
				}
				if(data[1].equals(graph.getName())){
					g2 = graph;
				}
			}

			if(g == null){
				g = new Graph();
				g.setName(data[0]);
			}

			if(g2 == null){
				g2 = new Graph();
				g2.setName(data[1]);
			}

			g.setNextDestination(g2);

			gSet.add(g);
			gSet.add(g2);

		}
		/**
		 * find the deepest node from Node Set
		 */
		return findTheDeepest(gSet).getName();
	}

	/**
	 * find the Deepest Node
	 * @param gSet
	 * @return
	 */
	private Graph findTheDeepest(Set<Graph> gSet){
		//DP(Dynamic Programming)
		Map<String, Integer> map = new HashMap<>();
		int theDepthest = 0;
		Graph theDepthestGraph = null;
		for(Graph graph : gSet){
			int tempDepth = checkDepth(graph, map);
			//store data for decreasing time complex
			map.put(graph.getName(), tempDepth);
			if(theDepthest < tempDepth){
				theDepthestGraph = graph;
				theDepthest = tempDepth;
			}
		}
		return theDepthestGraph;
	}

	/**
	 * calculate depth
	 * @param graph
	 * @param map
	 * @return
	 */
	private int checkDepth(Graph graph, Map<String, Integer> map){
		// if already calculate depth, return that value
		if(map.containsKey(graph.getName())){
			return map.get(graph.getName());
		}
		if(graph.getNextDestination() != null){
			return checkDepth(graph.getNextDestination(), map) + 1;
		}
		return 1;
	}

	/**
	*
	* ----------------------------------- solution 1 end ---------------------------------------------
	*
	*/

	/**
	*
	* ----------------------------------- solution 2 start ---------------------------------------------
	*
	*/


	/**
	 * find a firstplace
	 * @param list
	 * @return
	 */
	public String findFirstPlace(List<String[]> list) {
		for(int i = 0 ; i < list.size(); i++) {
			//if i first place contain in second place, that isn't starting place
			if (containsPlace(list, list.get(i)[0])){
				return list.get(i)[0];
			}
		}
		return "";
		
	}
	/**
	 * check the contain place
	 * @param list
	 * @param firstPlace
	 * @return
	 */
	private boolean containsPlace(List<String[]> list, String firstPlace) {
		for(int i = 0 ; i < list.size(); i++) {
			//if i first place contain in second place, i return false 
			if(list.get(i)[1].equals(firstPlace)) {
				return false ;
			}
		}
		return true;
	}

	/**
	 *
	 * ----------------------------------- solution 2 end ---------------------------------------------
	 *
	 */

}