package com.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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

        Stack<String> stack = new Stack();
        for(String string : strings){
            if(isBracketDirection(string)){
                stack.add(string);
            }
            else{
                if(stack.size() == 0 || !stack.peek().equals(reverseBracket(string))){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }

        return stack.size() == 0 ? true : false;
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