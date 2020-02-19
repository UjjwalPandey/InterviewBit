/* You are given a string S, and you have to find all the amazing substrings of S.
        Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
        Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.

        Input
            ABEC

        Output
            6

        Explanation
            Amazing substrings of given string are :
            1. A
            2. AB
            3. ABE
            4. ABEC
            5. E
            6. EC
            here number of substrings are 6 and 6 % 10003 = 6.

 */
package Strings;

public class AmazingSubarrays {
    public static void main(String[] args) {
        String s = "ABEC";
        System.out.println(isAmazing(s));
    }
    public static int isAmazing(String A) {
        int res =0;
        int len = A.length();
        for(int i=0; i< len; i++){
            if(isVowel(A.charAt(i))){
                res += len-i;
            }
        }
        return  res%10003;
    }

    public static boolean isVowel(char A) {
        String x = String.valueOf(A).toLowerCase();
        return  x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u");

    }
}
