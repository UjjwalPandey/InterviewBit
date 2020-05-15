/*  Min Sum Path in Matrix

    Problem Description

    Given a M x N grid A filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    Return the minimum sum of the path.

    NOTE: You can only move either down or right at any point in time.



    Problem Constraints

    1 <= M, N <= 1000

    -1000 <= A[i][j] <= 1000



    Input Format

    First and only argument is a 2-D grid A.


    Output Format

    Return an integer denoting the minimum sum of the path.


    Example Input

    Input 1:

    A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]

    Input 2:

    A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]



    Example Output

    Output 1:

    8

    Output 2:

    -1



    Example Explanation

    Explanation 1:

    The path will be: 1 -> 3 -> 2 -> 1 -> 1.

    Input 2:

    The path will be: 1 -> -3 -> 5 -> -5 -> 1.

 */
package DP;

public class MinSumPathInMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 3, 2},
                {4, 3, 1},
                {5, 6, 1}};
        int[][] B = {{1, -3, 2},
                {2, 5, 10},
                {5, -5, 1}};
        System.out.println(minPathSum(A));
        System.out.println(minPathSum(B));
    }

    public static int minPathSum(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] DP = new int[M][N];
        DP[0][0] = A[0][0];
        for(int i=0; i < M; i++){
            for(int j =0; j < N; j++){
                if(i==0 && j==0)continue;
                if(i ==0){
                    DP[i][j] = DP[i][j-1]+A[i][j];
                }else if(j ==0){
                    DP[i][j] = DP[i-1][j]+A[i][j];
                }else{
                    DP[i][j] = Math.min(DP[i][j-1],DP[i-1][j])+A[i][j];
                }
            }
        }


        return DP[M-1][N-1];
    }
}
