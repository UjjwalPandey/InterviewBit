/*  Number of islands

Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that
A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.

Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 100

0 <= A[i] <= 1



Input Format

The only argument given is the integer matrix A.


Output Format

Return the number of islands.


Example Input

Input 1:

 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]

Input 2:

 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]



Example Output

Output 1:

 2

Output 2:

 5



Example Explanation

Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].

Explanation 2:

 There 5 island in total.

 */

//  FAMOUS AMAZON QUESTION
package GraphDataStructureAlgorithms;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(totalIslands(A));
    }

    // SIMILAR TO TOTAL NUMBER OF CONNECTED COMPONENTS
    static int[][] A;
    public static int totalIslands(int[][] arr) {
        int count =0;
        int M = arr.length;
        int N = arr[0].length;
        A = arr;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1){
                    arr[i][j] =0;
                    dfs( i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j) {
        A[i][j] = 0;
        if(i > 0) {
            if (A[i - 1][j] == 1) {
                dfs(i - 1, j);
            }
            if(j > 0) {
                if (A[i - 1][j - 1] == 1) {
                    dfs(i - 1, j - 1);
                }
            }
            if(j < A[0].length-1){
                if(A[i-1][j+1] == 1){
                    dfs(i-1, j+1);
                }
            }
        }
        if(j > 0) {
            if (A[i][j - 1] == 1) {
                dfs(i, j - 1);
            }
            if(i < A.length-1) {
                if (A[i + 1][j - 1] == 1) {
                    dfs(i + 1, j - 1);
                }
            }
        }
        if(i < A.length-1) {
            if (A[i + 1][j] == 1) {
                dfs(i + 1, j);
            }

        }
        if(j < A[0].length-1) {
            if (A[i][j + 1] == 1) {
                dfs(i, j + 1);
            }
            if(i < A.length-1) {
                if (A[i + 1][j + 1] == 1) {
                    dfs(i + 1, j + 1);
                }
            }
        }
    }
}
