/*  Longest Common Subsequence

    Given two strings A and B. Find the longest common sequence ( A sequence which does not need to be contiguous), which is common in both the strings.

    You need to return the length of such longest common subsequence.

    NOTE:

    Your code will be run on multiple test cases (<=10). Try to come up with an optimised solution.

    CONSTRAINTS

    1 <= Length of A, B <= 10^3 + 5

    EXAMPLE INPUT

    A : "abbcdgf"
    B : "bbadcgf"

    EXAMPLE OUTPUT

    5

    EXPLANATION

    The longest common subsequence is "bbcgf", which has a length of 5

 */
package DP;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(solve("abbcdgf", "bbadcgf"));
    }
    public static int solve(String A, String B) {
        int M = A.length()+1, N = B.length()+1;
        int[][] DP = new int[M+1][N+1];
        for(int i=0; i< M; i++){
            for (int j=0; j< N; j++){
                if (i == 0 || j == 0)
                    DP[i][j] = 0;
                else if (A.charAt(i-1) == B.charAt(j-1))
                    DP[i][j] = DP[i-1][j-1] + 1;
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
//                System.out.print(DP[i][j]+" , ");
            }
//            System.out.println();
        }
        return DP[M-1][N-1];
    }
}
