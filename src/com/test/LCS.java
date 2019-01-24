package com.test;

/**
 *
 * LCS
 *
 * @author ohdoking
 *
 * This question is for improving algorithm solving problems using DP(Dynamic Programming).
 *
 *
 *
 */
public class LCS {


    public int LCSLength(String s1, String s2) {
        int DP[][] = new int[s1.length() + 1][s2.length() + 1];


        for(int i = 1 ; i <= s1.length(); i++){
            for(int j = 1 ; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                else{
                    DP[i][j] = Math.max(DP[i - 1][j] , DP[i][j - 1]);
                }
            }
        }

        return DP[s1.length()][s2.length()];

    }
}
