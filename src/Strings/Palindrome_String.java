/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */
package Strings;

public class Palindrome_String {
    public static void main(String[] args) {
        String A = "A man, a plan, a canal: Panama";
//        String A = "race a car";
        System.out.println(isPalindrome(A));
    }
    public static int isPalindrome(String A) {
        if(A.isEmpty()) return 0;
        String str = A.trim().replace(" ","").toLowerCase();
        int len = str.length();
        int i = 0, j = len-1;
        while(i <= j){
            if((!Character.isDigit(str.charAt(i))) && !Character.isLetter(str.charAt(i))) {
                i++;
                continue;
            }
            if((!Character.isDigit(str.charAt(j))) && !Character.isLetter(str.charAt(j))) {
                j--;
                continue;
            }
            if(str.charAt(i) != str.charAt(j))
                return 0;
            i++;
            j--;
        }
        return  1;
    }


}
