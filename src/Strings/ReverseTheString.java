/*  Reverse the String

    Given a string A. Return the string A after reversing the string word by word. NOTE:
    A sequence of non-space characters constitutes a word.
    Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    If there are multiple spaces between words, reduce them to a single space in the reversed string.

    Input Format
    The only argument given is string A.
    Output Format
    Return the string A after reversing the string word by word.
    For Example
    Input 1:
        A = "the sky is blue"
    Output 1:
        "blue is sky the"

    Input 2:
        A = "this is ib"
    Output 2:
        "ib is this"

 */
package Strings;

public class ReverseTheString {
    public static void main(String[] args) {
        System.out.println(reverseString("the sky is blue"));
        System.out.println(reverseString("this is ib"));
        System.out.println(reverseString("A     b c d "));
    }

    public static String reverseString(String A) {
        String[] split = A.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i= split.length-1; i>=0; i--){
            res.append(split[i]).append(" ");
        }
        return res.toString().trim();
    }
}
