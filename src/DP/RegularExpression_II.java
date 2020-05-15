/*  Regular Expression II

Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104


Input Format

The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.


Output Format

Return 1 if the patterns match else return 0.


Example Input

Input 1:

 A = "aab"
 B = "c*a*b"

Input 2:

 A = "acz"
 B = "a.a"



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 So, return 1.

Explanation 2:

 '.' matches any single character. First two character in string A will be match.
 But the last character i.e 'z' != 'a'. Return 0.

 */
package DP;

public class RegularExpression_II {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static int isMatch(final String A, final String B) {
        return _isMatch(A,0,B,0)?1:0;
    }

    public static boolean _isMatch(final String A, int s, final String B, int p){
        if(p == B.length())        return s == A.length();

        boolean star = p < B.length()-1 && B.charAt(p + 1) == '*';
        boolean match = s < A.length() &&  (B.charAt(p) == '.' || A.charAt(s) == B.charAt(p));
        // if there's kleene
        if(star){
            // don't match rec, match rec.
            return _isMatch(A, s, B, p+2) || ( match && _isMatch(A, s+1, B, p));
        }
        return match && _isMatch(A, s+1, B, p+1);
    }
}
