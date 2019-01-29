package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Regular Expression Matching
 *
 * @author ohdoking
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * Note:
 *  s could be empty and contains only lowercase letters a-z.
 *  p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 *  this is sort description about this problem
 *  now i'm gonna implement code following by this description.
 *
 *  before i implement, i'm gonna walk you through how i implement this is.
 *
 *
 * first of all, i'll seperate each parameter for interprete.
 * and i'll check each character using for loop
 *
 * for example s equals aa and a equal a in case
 *
 * aa i'm gonna split each character like this p[a], s[a,a] each s and p
 * and i'm gonna find in loop using p
 *
 * each loop i add the one condition
 *
 *
 *
 * first index i = 0:
 *      i'll check first index p array a with a
 *      both is equals , i'll pass the next index
 * index i == 1:
 *      but p array length is 1 so this array is end
 *
 * index is equal to s arraylenght each times
 *
 * but i didn't finish to check all of s[a] array.
 * so i return false;
 *
 *
 *
 */
class Solution24 {

    /**
     *
     * @param s could be empty and contains only lowercase letters a-z.
     * @param p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * @return
     */
    public boolean isMatch(String s, String p) {

        char[] text = s.toCharArray();
        char[] condition = p.toCharArray();

        int checkIndex = 0;

        for(int i = 0 ; i < condition.length; i++){
            if((int)condition[i] > 96 && (int)condition[i] < 123){
                if(condition.length > i+1 && condition[i+1] == '*'){
                    for(int j = checkIndex ; j < text.length ; j++){
                        if(text[j] != condition[i]){
                            break;
                        }
                        checkIndex++;
                    }
                    i++;
                }
                else{
                    if(text[checkIndex++] != condition[i]){
                        break;
                    }
                }
            }
            else if(condition[i] == '.'){
                if(condition.length > i+1 && condition[i+1] == '*'){
                    for(int j = checkIndex ; j < text.length ; j++){
                        checkIndex++;
                    }
                    i++;
                }
                else{
                    // i don't need to check this letter is same with other
                    checkIndex++;
                }
            }
        }

        if(text.length > checkIndex){
            return false;
        }
        return true;


        
    }
}