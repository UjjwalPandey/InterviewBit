package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String[] N = {"MCMXII", "IV", "XXIX", "LXV","XXX","LD","MMDCCCXLV","XLV"};   // 1912
        for (String s : N) System.out.println(romanToInteger(s));
    }

    private static int romanToInteger(String n) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);
        roman.put("i",1);
        roman.put("v",5);
        roman.put("x",10);
        roman.put("l",50);
        roman.put("c",100);
        roman.put("d",500);
        roman.put("m",1000);

        int res = 0;
        String[] romanChars = n.trim().split("");
        int[] romanIntVal = new int[romanChars.length];

        for(int i=0; i<romanChars.length; i++){
            int x  = roman.getOrDefault(romanChars[i],-1);
            if(x == -1) return -1;
            romanIntVal[i] = x;

        }
        int i=0;
        boolean lastValInNegative = true;
        while(i+1 < romanIntVal.length){
           if(romanIntVal[i] < romanIntVal[i+1]) {
               res += (romanIntVal[i + 1] - romanIntVal[i]);
               i+=2;
               if(i == romanIntVal.length-1) res += romanIntVal[i];
               lastValInNegative = false;
           }else{
               res += romanIntVal[i];
               i++;
               lastValInNegative = true;
           }
        }
        if(lastValInNegative) res += romanIntVal[romanIntVal.length-1];

        return res;
    }
}
