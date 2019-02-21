package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Group Anagrams
 *
 * @author ohdoking
 *
 * Given an array of strings, group anagrams together.
 *
 */
class Solution39 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();

        for(int i = 0 ; i < strs.length ; i++ ){
            boolean state = true;
            for(int j = 0 ; j < resultList.size() ; j++){
                if(reorder(resultList.get(j).get(0)).equals(reorder(strs[i]))){
                    resultList.get(j).add(strs[i]);
                    state = false;
                    break;
                }
            }
            if(state){
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                resultList.add(tempList);
            }
        }
        return resultList;
    }

    private String reorder(String str) {
        return str.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }
}