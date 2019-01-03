package com.test;
public class UserInput {
    
    public static class TextInput {
    	private String result = "";
    	
    	public void add(char c) {
    		result = result.concat(String.valueOf(c));
    	}
    	
    	public String getValue() {
    		return result;
    	}
    }

    public static class NumericInput extends TextInput {
    	
    	public void add(char c) {
    		if(!Character.isDigit(c)) {
    			return;
    		} 
    		super.add(c);
    	}
    	
    }
}