package com.test;

/**
 * ZigZag Conversion
 *
 * @author ohdoking
 * 2 : 2 + (2-2) -> 2 in 1
 * 3 : 3 + (3-2) -> 4 in 2
 * 4 : 4 + (4-2) -> 6 in 3
 * 5 : 5 + (5-2) -> 8 in 4
 * 6 : 6 + (6-2) -> 10 in 5
 *
 *
 * 100
 *
 * 2 : 50
 * 3 : 50
 * 4 : 16*3 = 48 approximately
 * 5 : 12*4 = 48
 * 6 : 50
 *
 */
class Solution19 {
    public String convert(String s, int numRows) {
        char[][] data = new char[numRows][(s.length()/2)+1];
        StringBuilder result = new StringBuilder();

        if(numRows == 1){
            return s;
        }

        int row = 0;
        int column = 0;
        boolean isDown = true;

        for(int i = 0 ; i < s.length(); i++){
            if(isDown){
                data[row++][column] = s.charAt(i);
                if(row == numRows - 1){
                    isDown = false;
                }
            }
            else{
                data[row--][column++] = s.charAt(i);
                if(row == 0){
                    isDown = true;
                }
            }
        }


        for(int i = 0 ; i < data.length; i++){
            for(int j = 0 ; j < data[0].length; j++){
                if(data[i][j] != '\0'){
                    result.append(data[i][j]);
                }
            }
        }

        return result.toString();

    }
}