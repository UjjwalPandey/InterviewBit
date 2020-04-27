/*  Unique Paths in a Grid

    Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

    Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    Example : There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
    [0,0,0],
    [0,1,0],
    [0,0,0]
    ]

    The total number of unique paths is 2.

    Note: m and n will be at most 100.

 */
package DP;

public class UniquePathsInAGrid {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}};
        int[][] B = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(A));
        System.out.println(uniquePathsWithObstacles(B));
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] DP = new int[M][N];
        DP[0][0] = (A[0][0] == 0)?1:0;
        for(int i=0; i < M; i++){
            for(int j =0; j < N; j++){
                if(i==0 && j==0)continue;
                if(i ==0){
                    DP[i][j] = (A[i][j] == 0)?DP[i][j-1]:0;
                }else if(j ==0){
                    DP[i][j] = (A[i][j] == 0)?DP[i-1][j]:0;
                }else{
                    DP[i][j] = (A[i][j] == 0)?DP[i][j-1]+DP[i-1][j]:0;
                }
            }
        }

        return DP[M-1][N-1];
    }
}
