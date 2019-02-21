package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Group Anagrams
 *
 * @author ohdoking
 *
 * Given an array of strings, group anagrams together.
 *
 * other answers
 *
 *     Approach 1: Categorize by Sorted String
 *
 *     public List<List<String>> groupAnagrams(String[] strs) {
 *         if (strs.length == 0) return new ArrayList();
 *         Map<String, List> ans = new HashMap<String, List>();
 *         for (String s : strs) {
 *             char[] ca = s.toCharArray();
 *             Arrays.sort(ca);
 *             String key = String.valueOf(ca);
 *             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
 *             ans.get(key).add(s);
 *         }
 *         return new ArrayList(ans.values());
 *     }
 *
 *     Approach 2: Categorize by Count
 *
 *     public List<List<String>> groupAnagrams(String[] strs) {
 *         if (strs.length == 0) return new ArrayList();
 *         Map<String, List> ans = new HashMap<String, List>();
 *         int[] count = new int[26];
 *         for (String s : strs) {
 *             Arrays.fill(count, 0);
 *             for (char c : s.toCharArray()) count[c - 'a']++;
 *
 *             StringBuilder sb = new StringBuilder("");
 *             for (int i = 0; i < 26; i++) {
 *                 sb.append('#');
 *                 sb.append(count[i]);
 *             }
 *             String key = sb.toString();
 *             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
 *             ans.get(key).add(s);
 *         }
 *         return new ArrayList(ans.values());
 *     }
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
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        return String.valueOf(ca);
    }
}