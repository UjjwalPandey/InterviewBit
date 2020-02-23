/* Given an string A. The only operation allowed is to insert characters in the beginning of the string.
    Find how many minimum characters are needed to be inserted to make the string a palindrome string.

    Input Format
        The only argument given is string A.
    Output Format
        Return the minimum characters that are needed to be inserted to make the string a palindrome string.

    Input 1:
        A = "ABC"
    Output 1:
        2
        Explanation 1:
            Insert 'B' at beginning, string becomes: "BABC".
            Insert 'C' at beginning, string becomes: "CBABC".

    Input 2:
        A = "AACECAAAA"
    Output 2:
        2
        Explanation 2:
            Insert 'A' at beginning, string becomes: "AAACECAAAA".
            Insert 'A' at beginning, string becomes: "AAAACECAAAA".
 */

package Strings;

public class MinimumCharactersRequiredToMakeStringPalindromic {
    public static void main(String[] args) {
        String[] str = {"abb","ABC","AACECAAAA","V","hqghumeaylnlfdxfi"};
        for(String s : str)System.out.println("Answer = "+numberOfCharactersRequired(s));
    }

    public static int numberOfCharactersRequired(String str) {
        int res =0;
        while (str.length() > 0) {
            if (isPalindrome(str)) {
                break;
            } else {
                res++;
                str = str.substring(0, str.length() - 1);
            }
        }
        return res;
    }
    static boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0, j = l - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
