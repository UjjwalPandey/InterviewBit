/*

    Longest Pallindromic Subsequence

    Given a strings A. Find the common palindromic sequence ( A sequence which does not need to be contiguous and is a palindrome),
    which is common in itself

    You need to return the length of such longest common subsequence.

    NOTE:

    Your code will be run on multiple test cases (<=10). Try to come up with an optimised solution.

    CONSTRAINTS

    1 <= Length of A, B <= 10^3 + 5

    EXAMPLE INPUT

    A : "bebeeed"

    EXAMPLE OUTPUT

    4

    EXPLANATION

    The longest common pallindromic subsequence is "eeee", which has a length of 4


 */
package DP;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(maxPalindrome("aedsead"));  // 5
        System.out.println(maxPalindrome("bebeeed"));  // 4
        System.out.println(maxPalindrome("ccdbaeeceecabaacebcaebdceaacdcdcbbadcebcaaceaebcdacccaedcbccacedaacdbaaeacdbeedccceeabececcc"));  // 61
        System.out.println(maxPalindrome("bebdeeedaddecebbbbbabebedc"));  // 13
    }

    private static int maxPalindrome(String A) {
        int N = A.length();
        int[][] dp = new int[N][N];
        int i, j, cl;
        for (i = 0; i < N; i++)
            dp[i][i] = 1;

        for (cl = 2; cl <= N; cl++) {
            for (i = 0; i < N - cl + 1; i++) {
                j = i + cl - 1;
                boolean b = A.charAt(i) == A.charAt(j);
                if (b && cl == 2)
                    dp[i][j] = 2;
                else if (b)
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][N - 1];
    }
}
