/*
    Length of Longest Fibonacci Subsequence

Problem Description

Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if

N > =3
Xi + Xi+1 = Xi+2 for all i+2 <= N

Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.



Problem Constraints

3 <= length of the array <= 1000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.


Example Input

Input 1:

 A = [1, 2, 3, 4, 5, 6, 7, 8]

Input 2:

 A = [1, 3, 7, 11, 12, 14, 18]



Example Output

Output 1:

 5

Output 2:

 3



Example Explanation

Explanation 1:

 The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].

Explanation 2:

 The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
 The length will be 3.
 */
package DP;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        System.out.println(longestFibonacci(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // 5
        System.out.println(longestFibonacci(new int[]{1, 3, 7, 11, 12, 14, 18})); // 3
        System.out.println(longestFibonacci(new int[]{7, 11, 16, 19, 26, 35, 36, 46, 47, 53, 56, 62})); // 3
        System.out.println(longestFibonacci(new int[]{1, 5, 6, 9, 17, 25, 29, 31, 39, 42, 46, 49, 57, 65, 75, 77, 82, 92, 95, 105, 113, 123, 132, 139, 142, 143, 152, 159, 162, 167, 177, 183, 186, 194, 196, 205, 215, 225, 233, 234, 238, 244, 250, 258, 266, 271, 274, 284, 292, 297, 307, 310, 320, 329, 330, 336, 342, 344, 347, 348, 350, 356, 362, 365, 373, 381, 391, 399, 406, 415, 420, 422, 430, 436, 440, 442, 446})); // 4
        System.out.println(longestFibonacci(new int[]{7, 14, 23, 28, 35, 41, 44, 48, 53, 58, 59, 60, 63, 65, 68, 69, 70, 73, 79, 83, 89, 99, 100, 109, 111, 120, 126, 128, 137, 141, 150, 158, 166, 172, 173, 181, 182, 186, 189, 198, 199, 200, 210, 217})); // 5
    }

    private static int longestFibonacci(int[] A) {
        int N = A.length;
        if(N < 3) return 0;
        boolean[] isPresent = new boolean[A[N-1]+1];
        int max = Integer.MIN_VALUE;
        for (int val : A) {
            isPresent[val] = true;
        }
        for(int i=0; i< N; i++){
            for(int j= i+1; j<N; j++){
                int first = A[i];
                int second = A[j];
                int nextSeq = first+second;
                if(nextSeq > A[N-1]) break;
                int counter = 2;
                while(isPresent[nextSeq]){
                    max = Math.max(max, ++counter);
                    first = second;
                    second = nextSeq;
                    nextSeq = first+second;
                    if(nextSeq > A[N-1]) break;
                }
            }
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }
}
