package com.test;

import java.util.LinkedList;
import java.util.List;

public class TrainComposition {
	
	List<Integer> trainList = new LinkedList<Integer>();
	
    public void attachWagonFromLeft(int wagonId) {
    	trainList.add(0, wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
    	trainList.add(wagonId);
    }

    public int detachWagonFromLeft() {
    	return trainList.remove(0);
    }

    public int detachWagonFromRight() {
    	return trainList.remove(trainList.size()-1);
    }
}