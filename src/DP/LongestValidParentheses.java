/*
Longest valid Parentheses

Problem Description

Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.



Problem Constraints

1 <= length(A) <= 750000


Input Format

The only argument given is string A.


Output Format

Return the length of the longest valid (well-formed) parentheses substring.


Example Input

Input 1:

 A = "(()"

Input 2:

 A = ")()())"



Example Output

Output 1:

 2

Output 2:

 4



Example Explanation

Explanation 1:

 The longest valid parentheses substring is "()", which has length = 2.

Explanation 2:

 The longest valid parentheses substring is "()()", which has length = 4.
 */
package DP;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    }
    /*
    1. s[i]=‘)’ and s[i−1]=‘(’
        dp[i]=dp[i−2]+2
    2. s[i]=‘)’ and s[i−1]=‘)’
        if s[i−dp[i−1]−1]=‘(’
        dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     */
    public static int longestValidParentheses(String A) {
        int res = 0;
        int[] dp = new int[A.length()];
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == ')') {
                if (A.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && A.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
