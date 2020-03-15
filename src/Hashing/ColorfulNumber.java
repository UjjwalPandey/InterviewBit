/*
    For Given Number N find if its COLORFUL number or not Return 0/1 COLORFUL number:
    A number can be broken into different contiguous sub-subsequence parts.
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different

    Example:
    N = 23
    2 3 23
    2 -> 2
    3 -> 3
    23 -> 6
    this number is a COLORFUL number since product of every digit of a sub-sequence are different.

    Output : 1
 */

package Hashing;

import java.util.HashMap;

public class ColorfulNumber {
    public static void main(String[] args) {
        System.out.println(colorful(3245));
    }

    public static int colorful(int A) {
         String strEqv = String.valueOf(A);
        int len = strEqv.length();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=1; i<= len; i++){
            for(int j=0; (j+i) <=len; j++ ){
                int prod = 1;
                for(int k = j; (k-j) < i; k++) {
                    prod *= (strEqv.charAt(k) - '0');
                }
//            System.out.println("For values for windowSize "+i+"  between "+strEqv.charAt(j)+"  and  "+strEqv.charAt(i+j-1)+"  =  "+prod);
                if(hm.containsKey(prod)){
                    return 0;
                }else{
                    hm.put(prod,1);
                }
            }
        }
        return 1;
    }
}
