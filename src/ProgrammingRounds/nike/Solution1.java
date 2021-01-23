/**
 *  Palindrome
 */
package ProgrammingRounds.nike;

public class Solution1 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("abcba"));
//        System.out.println(isPalindrome("ab1ba"));
//        System.out.println(isPalindrome("abcba"));
//        System.out.println(isPalindrome("dalda"));
//        System.out.println(isPalindrome(""));
//        System.out.println(isPalindrome("a"));
//        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("-1"));
        System.out.println(isPalindrome(null));
    }

    private static boolean isPalindrome(String str) {
        if(str == null) return false;
        int N = str.length();
        if(N == 0) return false;
        if(N == 1) return true;
        for(int i=0; i<=N/2; i++){
            if(str.charAt(i) != str.charAt(N-i-1)){
                return false;
            }
        }
        return true;
    }


}
