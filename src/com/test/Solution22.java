package com.test;

import java.util.stream.Stream;

class Solution22 {
    public int myAtoi(String str) {

        if(str.equals("") || str.equals("-")){
            return 0;
        }
        int result = 0;

        String[] data = str.replace(" ","").split("");

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < data.length; i++){
            if("-".equals(data[i]) || Character.isDigit(data[i].charAt(0))){
                sb.append(data[i]);
                continue;
            }
            //deal with exception
            if(i == 0){
                sb.append(0);
                break;
            }
        }
        try{
            result = Integer.valueOf(sb.toString());
        }
        catch(NumberFormatException e){
            result = Double.valueOf(sb.toString()) > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return result;

    }
}