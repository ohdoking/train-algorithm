package com.test;

import java.util.Arrays;

/**
 * Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 */
class Solution28 {
    enum Roman{
        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private String parent;
        private int value;

        Roman(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * int to Roman Number
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();

        for(Roman roman: Roman.values()){
            int temp = num / roman.getValue();
            for(int i = 0 ; i < temp ; i++){
                result.append(roman.name());
            }
            num -= temp * roman.getValue();
        }
        return result.toString();
    }

    /**
     * Roman to Int Number
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        String[] arr = s.split("");
        int result = 0;

        for(Roman roman: Roman.values()){
            while(arr.length != 0){
                if(roman.name().length() > 1 && 1 < arr.length){
                    if(roman.name().equals(arr[0].concat(arr[1]))){
                        result += roman.getValue();
                        arr = Arrays.copyOfRange(arr, 2, arr.length);
                    }
                }
                else{
                    if(roman.name().equals(arr[0])){
                        result += roman.getValue();
                        arr = Arrays.copyOfRange(arr, 1, arr.length);
                        //roman number can write continuously until 3 letter.
                        continue;
                    }
                }
                break;
            }
        }

        return result;
    }
}