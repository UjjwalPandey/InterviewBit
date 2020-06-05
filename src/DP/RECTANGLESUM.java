/*
RECTANGLE SUM

Problem Description

Given a matrix of integers A of size N x M.

Calculate the sum of all submatrices and return the maximum among all those sums.

NOTE: Empty submatrix also need to be considered.



Problem Constraints

1 <= N, M <= 100
-10000 <= A[i] <= 10000


Input Format

The first and only argument given is the integer matrix A.


Output Format

Return the maximum sum among all those sums of all possible submatrices.


Example Input

Input 1:

 A = [
       [1, 3, -2]
       [1, 4, 6]
       [-4, -2, 1]
     ]

Input 2:


A = [
      [-1, -1]
      [-1, -1]
    ]



Example Output

Output 1:

 13

Output 2:

 0



Example Explanation

Explanation 1:

 Submatrix giving maximum sum is :
    [
       [1, 3, -2]
       [1, 4, 6]
    ]

Explanation 2:

 Sum of empty submatrix will be 0.
 */
package DP;

public class RECTANGLESUM {
    public static void main(String[] args) {
        int[][]  A = {{1, 3, -2},
                {1, 4, 6},
                {-4, -2, 1}};
        System.out.println(solve(A));
        int[][]  B = {{-1, -1},
                {-1, -1}};
        System.out.println(solve(B));
    }

    public static int solve(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] preSum = new int[m+1][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                preSum[i+1][j] = preSum[i][j] + A[i][j];
            }
        }

        int maxSum = -1;
        int minSum = Integer.MIN_VALUE;
        for(int rowStart = 0; rowStart < m; rowStart++) {
            for(int row = rowStart; row < m; row++){
                int sum = 0;
                for(int col = 0; col < n; col++) {
                    sum += preSum[row+1][col] - preSum[rowStart][col];
                    if(sum < 0) {
                        if(minSum < sum) {
                            minSum = sum;
                        }
                        sum = 0;
                    }
                    else if(maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }
        }
        int res = maxSum == -1 ? minSum : maxSum;
        return Math.max(res, 0);
    }
}
