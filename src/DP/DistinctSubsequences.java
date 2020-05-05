/*  Distinct Subsequences

    Problem Description

    Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

    Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



    Problem Constraints

    1 <= length(A), length(B) <= 700


    Input Format

    The first argument of input contains a string A.
    The second argument of input contains a string B.


    Output Format

    Return an integer representing the answer as described in the problem statement.


    Example Input

    Input 1:

     A = "abc"
     B = "abc"

    Input 2:

     A = "rabbbit"
     B = "rabbit"



    Example Output

    Output 1:

     1

    Output 2:

     3



    Example Explanation

    Explanation 1:

     Both the strings are equal.

    Explanation 2:

     These are the possible removals of characters:
        => A = "ra_bbit"
        => A = "rab_bit"
        => A = "rabb_it"

     Note: "_" marks the removed character.



 */
package DP;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(distinct("rabbbit", "rabbit"));
        System.out.println(distinct("roabobi", "rabi"));
        System.out.println(distinct("rboabobi", "rabi")); // 2
    }

    private static int distinct(String A, String B) {
//        return eval(A.toString(), B,A.length()-1,B.length()-1);
        int n = A.length();
        int m = B.length();
        int[] dp = new int[m+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = m; j >= 1; j--) {
                if(A.charAt(i-1) == B.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }
        return dp[m];
    }

    private static int eval(String A, String B, int i, int j) {
        if (i < 0 || j < 0 || i < j)
            return 0;

        if (A.charAt(i)==B.charAt(j)) {
            if (j == 0)
                return eval(A, B, i-1, j) + 1;
            else {
                return eval(A, B, i-1, j) + eval(A, B, i-1, j-1);
            }
        }
        return eval(A, B, i-1, j);
    }
}
