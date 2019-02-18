package com.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * Valid Parentheses
 *
 * @author ohdoking
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
class Solution33 {
    public boolean isValid(String s) {

        if(s.length() == 0){
            return true;
        }
        String[] strings = s.split("");

        ArrayDeque<String> queue = new ArrayDeque();
        for(String string : strings){
            if(isBracketDirection(string)){
                queue.add(string);
            }
            else{
                if(!queue.getLast().equals(reverseBracket(string))){
                    return false;
                }
                else{
                    queue.pollLast();
                }
            }
        }

        return queue.size() == 0 ? true : false;
    }

    public boolean isBracketDirection(String bracket){
        boolean state = false;
        if(bracket.equals("(") || bracket.equals("{") || bracket.equals("[")){
            state = true;
        }
        return state;
    }

    public String reverseBracket(String bracket){
        String string = "";
        switch (bracket){
            case ")":
                string = "(";
                break;
            case "}":
                string = "{";
                break;
            case "]":
                string = "[";
                break;
        }
        return string;
    }
}