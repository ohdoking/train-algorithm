package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution12 {

    // please transform the map to a new map so
    // that the values become the keys and the keys become the values

    public Map<String, String> emailToUuid = new HashMap<String, String>(){
        {
            put("me@example.com", "17f607e8-dce5-11e8-b000-afac60a27cb3");
            put("you@example.com", "22287d90-dce5-11e8-aab1-8335ac47475d");
        }
    };
    
    public Map<String, String> changeKeyAndValue() {
    	Map<String, String> tempMap = new HashMap<String, String>();
    	for(String key :  emailToUuid.keySet()) {
    		//TODO i should think about value of value is 
    		tempMap.put(emailToUuid.get(key), key);
    	}
    	return tempMap;
    	
    }

}