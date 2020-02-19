/* mplement strStr().

     strstr - locate a substring ( needle ) in a string ( haystack ).
        Try not to use standard library string functions for this question.

    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

     NOTE: Good clarification questions:
        What should be the return value if the needle is empty?
        What if both haystack and needle are empty?
        For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
package Strings;

public class ImplementStrStr {
    public static void main(String[] args) {
        String A = "bbbbbbbbab";
        String B = "baba";
        System.out.println(strStr(A,B));
    }
    public static int strStr(final String A, final String B) {
        int lenA = A.length();
        int lenB = B.length();
        if(lenA==0 || lenB==0 || lenA < lenB) return -1;

        for(int i=0; i< lenA; i++){
            int j;
            for(j=0; j< lenB && i+j < lenA; j++){
                if(B.charAt(j) != A.charAt(i+j)) break;
            }
            if(j==lenB) return  i;
        }
        return -1;
    }
}
