/*  Palindrome Partitioning II

    Problem Description

    Given a string A, partition A such that every substring of the partition is a palindrome.

    Return the minimum cuts needed for a palindrome partitioning of A.

    Problem Constraints

    1 <= length(A) <= 501


    Input Format

    The first and the only argument contains the string A.


    Output Format

    Return an integer, representing the minimum cuts needed.


    Example Input

    Input 1:

     A = "aba"

    Input 2:

     A = "aab"



    Example Output

    Output 1:

     0

    Output 2:

     1



    Example Explanation

    Explanation 1:

     "aba" is already a palindrome, so no cuts are needed.

    Explanation 2:

     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 */
package DP;

public class PalindromePartitioning_II {
    public static void main(String[] args) {
        System.out.println(minCut("aba")); // 0
        System.out.println(minCut("aab")); // 1
        System.out.println(minCut("ababbabbababa")); // 2
        System.out.println(minCut("abcd")); // 3
    }
    public static int minCut(String A) {
        int N = A.length();
        boolean[][] dp = new boolean[N][N];
        int[][] cuts = new int[N][N];
        // For Palindrome length == 1
        for(int i=0; i< N; i++){
            dp[i][i] = true;
            cuts[i][i] = 0;
        }

        // For Palindrome length > 1
        for(int len = 2; len <=N; len++){
            for(int i=0; i<= N-len; i++){
                int j = i+len-1;
                boolean sameCharacters = A.charAt(i) == A.charAt(j);
                // Filling DP Table
                if(len == 2){
                    dp[i][j] = sameCharacters;
                }else {
                    dp[i][j] = sameCharacters && dp[i + 1][j - 1];
                }
                // Filling cuts Table
                if(dp[i][j]){
                    cuts[i][j] = 0;
                }else {
                    cuts[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        cuts[i][j] = Math.min(cuts[i][j], 1 + cuts[i][k] + cuts[k + 1][j]);
                    }
                }

            }
        }
        return cuts[0][N-1];
    }
}
