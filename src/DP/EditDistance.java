/*  Edit Distance

    Problem Description

    Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character



    Problem Constraints

    1 <= length(A), length(B) <= 450


    Input Format

    The first argument of input contains a string, A.
    The second argument of input contains a string, B.


    Output Format

    Return an integer, representing the minimum number of steps required.


    Example Input

    Input 1:

     A = "abad"
     B = "abac"

    Input 2:

     A = "Anshuman"
     B = "Antihuman



    Example Output

    Output 1:

     1

    Output 2:

     2



    Example Explanation

    Exlanation 1:

     A = "abad" and B = "abac"
     After applying operation: Replace d with c. We get A = B.


    Explanation 2:

     A = "Anshuman" and B = "Antihuman"
     After applying operations: Replace s with t and insert i before h. We get A = B.



 */
package DP;

public class EditDistance {
    public static void main(String[] args) {
//        System.out.println(minDistance("aaa","aa")); // 1
//        System.out.println(minDistance("abac","aac")); // 1
//        System.out.println(minDistance("Anshuman","Antihuman"));  // 2
//        System.out.println(minDistance("abad","abac"));  // 1
//        System.out.println(minDistance("bbbaabaa","aababbabb"));  // 5
//        System.out.println(minDistance("babaaabaaab","ababaabbab"));  // 4
//        System.out.println(minDistance("abcda","bcd"));  // 2
        System.out.println(minDistance("abdca","bdc"));  // 4
    }


    private static int minDistance(String A, String B) {
//        return evaluate(A, B, A.length(),B.length());
        return evaluateDP(A, B, A.length(),B.length());
    }

    private static int evaluateDP(String A, String B, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0) dp[i][j] = j;
                else if(j==0) dp[i][j] = i;
                else if(A.charAt(i-1) == B.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = 1+ Math.min(dp[i][j-1],
                            Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }

    // Recursive Solution -- Involves concurrent Sub-problems.
    // Time Complexity = O(3^s2)
    private static int evaluate(String a, String b, int s1, int s2) {
        if (s1 == 0)
            return s2;
        if (s2 == 0)
            return s1;
        if (a.charAt(s1 - 1) == b.charAt(s2 - 1))
            return evaluate(a, b, s1 - 1, s2 - 1);

        return 1 + Math.min(evaluate(a, b, s1, s2 - 1), // Insert
                Math.min(evaluate(a, b, s1 - 1, s2), // Remove
                evaluate(a, b, s1 - 1, s2 - 1)) // Replace
        );
    }
}
