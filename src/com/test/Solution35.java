package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }


}