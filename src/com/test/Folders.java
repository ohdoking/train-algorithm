package com.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    	
    	Collection<String> collection = new HashSet<String>();
    	
    	Pattern folderPattern = Pattern.compile("(<folder name=\")(.*?)(\".*?>)");
    	Matcher folderMacher = folderPattern.matcher(xml);
    	
    	while (folderMacher.find()) {
    	    for (int i = 0; i < folderMacher.groupCount() - 2; i += 2) {
    	    	
    	    	String tempResult = folderMacher.group(i+2);
    	    			
    	    	if(tempResult.startsWith(String.valueOf(startingLetter))) {
    	    		collection.add(tempResult);
    	    	}
    	    }
    	}
    	
    	return collection;
    }
}