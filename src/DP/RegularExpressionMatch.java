/*  Regular Expression Match

    Implement wildcard pattern matching with support for '?' and '*' for strings A and B.

    '?' : Matches any single character.
    '*' : Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    Input Format:

    The first argument of input contains a string A.
    The second argument of input contains a string B.

    Output Format:

    Return 0 or 1:
    => 0 : If the patterns do not match.
    => 1 : If the patterns match.

    Constraints:

    1 <= length(A), length(B) <= 9e4

    Examples :

    Input 1:
    A = "aa"
    B = "a"

    Output 1:
    0

    Input 2:
    A = "aa"
    B = "aa"

    Output 2:
    1

    Input 3:
    A = "aaa"
    B = "aa"

    Output 3:
    0

    Input 4:
    A = "aa"
    B = "*"

    Output 4:
    1

    Input 5:
    A = "aa"
    B = "a*"

    Output 5:
    1

    Input 6:
    A = "ab"
    B = "?*"

    Output 6:
    1

    Input 7:
    A = "aab"
    B = "c*a*b"

    Output 7:
    0

    ×
    -->


 */
package DP;

import java.util.Arrays;

public class RegularExpressionMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); //0
        System.out.println(isMatch("aa", "aa")); //1
        System.out.println(isMatch("aaa", "aa")); //0
        System.out.println(isMatch("aa", "*")); //1
        System.out.println(isMatch("aa", "a*")); //1
        System.out.println(isMatch("aa", "?*")); //1
        System.out.println(isMatch("aa", "c*a*b")); //0
        System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a**************************************************************************************")); //1
        System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "*b")); //0
        System.out.println(isMatch("*b","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); //0
        System.out.println(isMatch("cacab","**bcbbac?ba")); //0
        System.out.println(isMatch("bcccaccabaaa","?*a?*ca")); //0
        System.out.println(isMatch("bacb","b**c*?*")); //1
    }

    public static int isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();

        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0)?1:0;

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initailze lookup table to false
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);

        // empty pattern can match with empty string
        lookup[0][0] = true;
        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (B.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (B.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];
                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (B.charAt(j - 1) == '?' ||
                        A.charAt(i - 1) == B.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m]?1:0;
    }
}
