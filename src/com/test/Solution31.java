package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Letter Combinations of a Phone Number
 *
 * @author ohdoking
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
class Solution31 {

    /**
     * 2 : a,b,c
     * 3 : d,e,f
     * 4,: g,h,i
     * 5 : j,k,l
     * 6 : m,n,o
     * 7 : p,q,r,s
     * 8 : t,u,v
     * 9 : w,x,y,z
     */
    Map<String, String[]> phone = new HashMap<String, String[]>() {{
        put("2", new String[]{"a","b","c"});
        put("3", new String[]{"d","e","f"});
        put("4", new String[]{"g","h","i"});
        put("5", new String[]{"j","k","l"});
        put("6", new String[]{"m","n","o"});
        put("7", new String[]{"p","q","r","s"});
        put("8", new String[]{"t","u","v"});
        put("9", new String[]{"w","x","y","z"});
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map the next available digit
            String digit = next_digits.substring(0, 1);
            String[] letters = phone.get(digit);
            for (int i = 0; i < letters.length; i++) {
                // append the current letter to the combination and proceed to the next digits
                backtrack(combination + letters[i], next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }
}