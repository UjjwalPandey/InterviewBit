/*  Sub-matrix Sum Queries

    Problem Description

    Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.

    Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

    NOTE:

        Rows are numbered from top to bottom and columns are numbered from left to right.
        Sum may be large so return the answer mod 109 + 7.



    Problem Constraints

    1 <= N, M <= 1000
    -100000 <= A[i] <= 100000
    1 <= Q <= 100000
    1 <= B[i] <= D[i] <= N
    1 <= C[i] <= E[i] <= M


    Input Format

    The first argument given is the integer matrix A.
    The second argument given is the integer array B.
    The third argument given is the integer array C.
    The fourth argument given is the integer array D.
    The fifth argument given is the integer array E.
    (B[i], C[i]) represents the top left corner of the i'th query.
    (D[i], E[i]) represents the bottom right corner of the i'th query.


    Output Format

    Return an integer array containing the submatrix sum for each query.


    Example Input

    Input 1:

     A = [   [1, 2, 3]
             [4, 5, 6]
             [7, 8, 9]   ]
     B = [1, 2]
     C = [1, 2]
     D = [2, 3]
     E = [2, 3]

    Input 2:

     A = [   [5, 17, 100, 11]
             [0, 0,  2,   8]    ]
     B = [1, 1]
     C = [1, 4]
     D = [2, 2]
     E = [2, 4]



    Example Output

    Output 1:

     [12, 28]

    Output 2:

     [22, 19]



    Example Explanation

    Explanation 1:

     For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
     For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.

    Explanation 2:

     For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
     For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.


 */
package DP;

public class SubMatrixSumQueries {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int[][] sum = preProcess(A);
        int[] res = new int[B.length];
        for(int i=0; i< B.length; i++)
            res[i]= findSubmatrixSum(sum, B[i]-1, C[i]-1,D[i]-1,E[i]-1);
        return res;
    }

    final static int VAL = 1000000007;
    public static int[][] preProcess(int[][] mat){
        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];
        // pre-process first row
        for (int j = 1; j < mat[0].length; j++) {
            sum[0][j] = (mat[0][j]%VAL + sum[0][j - 1]%VAL)%VAL;
        }
        // pre-process first column
        for (int i = 1; i < mat.length; i++) {
            sum[i][0] = (mat[i][0]%VAL + sum[i - 1][0]%VAL)%VAL;
        }
        // pre-process rest of the matrix
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sum[i][j] = (mat[i][j]%VAL + sum[i - 1][j]%VAL + sum[i][j - 1]%VAL
                        - sum[i - 1][j - 1]%VAL)%VAL;
            }
        }
        return  sum;
    }

    public static int findSubmatrixSum(int[][] sum, int p, int q, int r, int s) {
        int total = sum[r][s];
        if (q - 1 >= 0) {
            total = (total%VAL - sum[r][q - 1]%VAL)%VAL;
        }
        if (p - 1 >= 0) {
            total = (total%VAL - sum[p - 1][s]%VAL)%VAL;
        }
        if (p - 1 >= 0 && q - 1 >= 0) {
            total = (total%VAL + sum[p - 1][q - 1]%VAL)%VAL;
        }
        return (VAL + total)%VAL;
    }
}
