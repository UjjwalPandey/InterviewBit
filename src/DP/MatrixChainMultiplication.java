/*  Matrix Chain Multiplication

    Problem Description

    Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].

    Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications,
    but merely to decide in which order to perform the multiplications.

    Return the minimum number of multiplications needed to multiply the chain.



    Problem Constraints

    1 <= length of the array <= 1000
    1 <= A[i] <= 100


    Input Format

    The only argument given is the integer array A.


    Output Format

    Return an integer denoting the minimum number of multiplications needed to multiply the chain.


    Example Input

    Input 1:

     A = [40, 20, 30, 10, 30]

    Input 2:

     A = [10, 20, 30]



    Example Output

    Output 1:

     26000

    Output 2:

     6000



    Example Explanation

    Explanation 1:

     Dimensions of A1 = 40 x 20
     Dimensions of A2 = 20 x 30
     Dimensions of A3 = 30 x 10
     Dimensions of A4 = 10 x 30
     First, multiply A2 and A3 ,cost = 20*30*10 = 6000
     Second, multiply A1 and (Matrix obtained after multiplying A2 and A3) =  40 * 20 * 10 = 8000
     Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
     Total Cost = 12000 + 8000 + 6000 =26000

    Explanation 2:

     Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.



    See Expected Output


 */

// Also try SPOJ://MIXTURES
package DP;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        System.out.println(minMatrixMultiplicationCost(new int[]{40, 20, 30, 10, 30}));
    }

    private static int minMatrixMultiplicationCost(int[] A) {
        // Cost of multiplying 2 matrices if dimension m*n & n*y will be m*n*y.
        int N = A.length;
        int[][] dp = new int[N-1][N-1];
        // dp[i][j] will signify the minimum cost to multiply matrices from ith matrix to jth matrix.
        for(int i=0; i < N-1; i++) dp[i][i] =0;

        for(int len =2; len <= N-1; len++){
            for(int i=0; i <N-len; i++){
                int j= i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k =i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],
                                        dp[i][k]+dp[k+1][j]+A[i]*A[k+1]*A[j+1]);
                }
            }
        }
        return dp[0][N-2];
    }
}
