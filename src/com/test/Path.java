package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {
    private String path;
    
    List<String> pathList = new ArrayList<String>();

    public Path(String path) {
        this.path = path;
        
        Arrays
        	.stream(path.split("/"))
        	.forEach(pathList::add);
    }

    public String getPath() {
        return pathList.stream().reduce("", (x,x2)->{
        	if("".equals(x2)) {
        		return x;
        	}
        	return x.concat("/"+x2);
        });
    }

    public void cd(String newPath) {
    	
    	Pattern folderPattern = Pattern.compile("([A-Za-z0-9_|..])+|/[\\s]");
    	Matcher folderMacher = folderPattern.matcher(newPath);
    	
    	while(folderMacher.find()) {
    		for (int i = 0; i < folderMacher.groupCount(); i++) {
    			System.out.println(folderMacher.group(i));
    			String tempResult = folderMacher.group(i);
    			if("..".equals(tempResult)) {
    				pathList.remove(pathList.size()-1);
    			}
    			else {
    				pathList.add(tempResult);
    			}
    			
    	    }
    	}
    	
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../../x");
        System.out.println(path.getPath());
    }
}