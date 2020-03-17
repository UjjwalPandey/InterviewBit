/*  Same Format String

    Given two strings A and B. Check if B contains same characters as that of given string A and in the same order. Note
    1: A and B contain only UPPERCASE Letters.
    2: No two consecutive characters are same in A.
    3: You can only use constant amount of extra memory.

    Input Format
    The first argument given is string A.
    The second argument given is string B.
    Output Format
    Return 1 if B contains same characters as that of given string A and in the same order else return 0.
    For Example
    Input 1:
        A = "HIRED"
        B = "HHHIIIRRRRREEEEEDDDDD"
    Output 1:
        1

    Input 2:
        A = "HIRED"
        B = "DDHHHHIIIIRRRRREEEEDDD"
    Output 2:
        0

 */
package Strings;

public class SameFormatString {
    public static void main(String[] args) {
        System.out.println(checkFormat("HIRED","HHHIIIRRRRREEEEEDDDDD"));  // 1
        System.out.println(checkFormat("HIRED","DDHHHHIIIIRRRRREEEEDDD"));  // 0
        System.out.println(checkFormat("DDHHHHIIIIRRRRREEEEDDD","HIRED"));  // 0
        System.out.println(checkFormat("HIR","HIRE")); // 0
        System.out.println(checkFormat("HIRE","HHIIIR")); // 0
    }

    public static int checkFormat(final String A, final String B) {
        int len1 = A.length(), len2 = B.length();
        if(len1 <= len2 ){
            int j =0;
            int i;
            for(i=0; i< len1; i++){
                if(A.charAt(i) != B.charAt(j)) return 0;
                while (j < len2){
                    if(A.charAt(i) == B.charAt(j)){
                        j++;
                    }else {
                        break;
                    }
                }
                if(j == len2) {
                    if(i != len1-1) return 0;
                }
            }
            if(j != len2) return 0;
//            System.out.println(len1+"  "+i+"  "+len2+"  "+j);
        }else{
            int i =0;
            int j;
            for(j=0; j< len2; j++){
                if(A.charAt(i) != B.charAt(j)) return 0;
                while (i < len1){
                    if(A.charAt(i) == B.charAt(j)){
                        i++;
                    }else {
                        break;
                    }
                }
                if(i == len1) {
                    if(j != len2-1) return 0;
                }
            }
            if(i != len1) return 0;
//            System.out.println(len1+"  "+i+"  "+len2+"  "+j);
        }
        return 1;
    }
}
