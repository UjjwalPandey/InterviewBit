/*
Arithmetic Subsequences

Problem Description

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

 1, 3, 5, 7, 9
 7, 7, 7, 7

Given an integer array A of size N. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk](0-based indexing) is arithmetic. In particular, this means that k ≥ 2.

Return the number of arithmetic subsequences slices in the array A.



Problem Constraints

1 <= N <= 1000

-105 <= A[i] <= 105



Input Format

The first and the only argument of input contains an integer array, A of size N.



Output Format

Return an integer representing the number of arithmetic subsequences in A.


Example Input

Input 1:

 A = [2, 4, 6, 8, 10]

Input 2:

 A = [3, 6, 7]



Example Output

Output 1:

 7

Output 2:

 0



Example Explanation

Explanation 1:

 All arithmetic subsequence slices are:
    [2, 4, 6]
    [4, 6, 8]
    [6, 8, 10]
    [2, 4, 6, 8]
    [4, 6, 8, 10]
    [2, 4, 6, 8, 10]
    [2, 6, 10]

Explanation 2:

 There are no possible arithmetic subseqence.
 */
package DP;


import java.util.HashMap;
import java.util.Map;

public class ArithmeticSubsequences {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 4, 6, 8, 10}));
    }

    public static int solve(int[] A) {
        int n = A.length;
        long ans = 0;
        Map<Integer, Integer>[] count = new HashMap[n];
        for (int i = 0; i < n; i++) {
            count[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = count[j].getOrDefault(diff, 0);
                int origin = count[i].getOrDefault(diff, 0);
                count[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int)ans;
    }
}
