/** A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).
 *  The robot can only move either down or right at any point in time.
 *  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *  How many possible unique paths are there? Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *  Example :
 Input : A = 2, B = 2
 Output : 2

 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 OR  : (0, 0) -> (1, 0) -> (1, 1)

 Note: Idea behind the Solution taken from  https://www.geeksforgeeks.org/maths-behind-number-of-paths-in-matrix-problem/
 *
 */

package Maths;

public class Grid_Unique_Path {
    public static void main(String[] args) {
        int A = 2, B = 3;
        int C = 3, D = 3;
        int E = 3, F = 4;
        int G = 100, H = 1;
        System.out.println(uniquePaths(A,B));
        System.out.println(uniquePaths(C,D));
        System.out.println(uniquePaths(E,F));
        System.out.println(uniquePaths(G,H));
    }


/**
 * 1-D Memory based solution
 * Still giving Out of Memory Error
    public static int uniquePaths(int A, int B) {
        int[] dp = new int[B];
        dp[0] = 1;
        for (int i = 0; i < A; i++) {
            for (int j = 1; j < B; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[B - 1];
    }
*/
    // Recursive Solution
    // TLE Exception
    /*public static int uniquePaths(int A, int B) {
        if(A==1 || B==1) return 1;
        return uniquePaths(A-1,B)+uniquePaths(A,B-1);
    }*/


    // 2-D Memory-based solution
    // -- giving out of heap-space error
    /*public static int uniquePaths(int A, int B) {
        int[][] mat = new int[A][B];
        mat[0][0]=1;
        for(int i =0; i< A; i++){
            mat[i][0]= 1;
        }
        for(int i =0; i< B; i++){
            mat[0][i]= 1;
        }
        for (int i=1; i< A; i++){
            for(int j=1; j<B; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[A-1][B-1];
    }*/

    // most efficient Solution using BINOMIAL COEFFICIENT.
// https://www.geeksforgeeks.org/maths-behind-number-of-paths-in-matrix-problem/
    static int uniquePaths(int m, int n) {
        return binomialCoeff(m+n-2, n-1);
    }
    static int binomialCoeff(int n, int k) {
        int res = 1;
        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;
        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
