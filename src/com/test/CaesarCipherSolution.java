package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// CaesarCipher from kata[https://www.codewars.com/kata/5508249a98b3234f420000fb/solutions/java]
public class CaesarCipherSolution {
  public static List<String>  movingShift(String s, int shift) {
    int firstPartsSize;
    if(s.length()%5==0) firstPartsSize=s.length()/5;
    else firstPartsSize=s.length()/5+1;
    
    char[] chars = s.toCharArray();
    for(int i = 0; i<chars.length; i++){
      chars[i] = Character.isLetter(chars[i])
                 ?Character.isUpperCase(chars[i])
                  ?(char)((((int)chars[i]-(int)'A')+shift+i)%26+(int)'A')
                  :(char)((((int)chars[i]-(int)'a')+shift+i)%26+(int)'a')
                 :chars[i];
    }
    String coded = new String(chars);
    return new ArrayList<String>(){
      {
        add(coded.substring(0,firstPartsSize));
        add(coded.substring(firstPartsSize,2*firstPartsSize));
        add(coded.substring(2*firstPartsSize,3*firstPartsSize));
        add(coded.substring(3*firstPartsSize,4*firstPartsSize));
        add(coded.substring(4*firstPartsSize));
      }
    };
  }
  
  public static String demovingShift(List<String> s, int shift) {
    String coded = s.stream().collect(Collectors.joining());
    char[] chars = coded.toCharArray();
    for(int i = 0; i<chars.length; i++){
      chars[i] = Character.isLetter(chars[i])
                 ?Character.isUpperCase(chars[i])
                  ?(char)((((int)chars[i]-(int)'A')-shift-i+(1+i/26)*26)%26+(int)'A')
                  :(char)((((int)chars[i]-(int)'a')-shift-i+(1+i/26)*26)%26+(int)'a')
                 :chars[i];
    }
    return new String(chars);
  }

}