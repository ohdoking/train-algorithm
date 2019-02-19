package com.test;

import com.test.fundamental.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Combination Sum
 *
 * @author ohdoking
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * i'm gonna walk through this problem first.
 *
 * [2,3,6,7] 7
 *
 * i'm gonna iterate over all number which is in array until find 7 which is a sum in array element.
 * i = 3
 * 7 = 7    -- o
 *
 * i = 2
 * 6 < 7
 *      j = 2
 *      6 + 6 = 12 > 7
 *      j = 1
 *      6 + 3 = 9 > 7
 *      j = 0
 *      6 + 2 = 8 > 7
 *
 * i = 1
 * 3 < 7
 *      j = 1
 *      3 + 3 = 6 < 7
 *          3 + 3 + 3 > 7
 *          j = 0
 *          3 + 3 + 2 = 8 > 7
 *      j = 0
 *      3 + 2 = 5 < 7
 *          3 + 2 + 2 = 7 ---- o
 *
 * i = 0
 * 2 > 7
 *      j = 0
 *      2 + 2 = 4 < 7
 *          2 + 2 + 2 = 6 < 7
 *              2 + 2 + 2 + 2 = 8 > 7
 *
 */
class Solution35 {

    int target = 0;
    int[] candidates;
    List<List<Integer>> resultList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        resultList = new ArrayList<>();

        for(int i = candidates.length - 1 ; i >= 0; i--){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(candidates[i]);
            if(candidates[i] == target){
                resultList.add(tempList);
                continue;
            }
            else{
                add(tempList, i);
            }
        }
        return resultList.stream().distinct().collect(Collectors.toList());
    }

    /**
     *  * i = 1
     *  * 3 < 7
     *  *      j = 1
     *  *      3 + 3 = 6 < 7
     *  *          3 + 3 + 3 > 7
     *  *          j = 0
     *  *          3 + 3 + 2 = 8 > 7
     *  *      j = 0
     *  *      3 + 2 = 5 < 7
     *  *          3 + 2 + 2 = 7 ---- o
     * @param list
     * @param index
     */
    public void add(List<Integer> list, int index) {
        List<Integer> tempList = new ArrayList<>(list);
        if(index < 0){
            return;
        }
        tempList.add(candidates[index]);
        if(sumList(tempList) == target){
            Collections.sort(tempList);
            resultList.add(tempList);
            return;
        }
        else if(sumList(tempList) > target){
            tempList.remove(tempList.size() - 1);
            add(tempList, index - 1);
        }
        else if(sumList(tempList) < target){
            add(tempList, index);
        }

        if(tempList.size() - 1 > 0){
            tempList.remove(tempList.size() - 1);
            add(tempList, index - 1);
        }
    }

    public int sumList(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }


}