/*  Given a matrix of integers A of size N x M . There are 4 types of squares in it:
        1. 1 represents the starting square.  There is exactly one starting square.
        2. 2 represents the ending square.  There is exactly one ending square.
        3. 0 represents empty squares we can walk over.
        4. -1 represents obstacles that we cannot walk over.
        Find and return the number of 4-directional walks from the starting square to the ending square,
        that walk over every non-obstacle square exactly once.

       Note: Rows are numbered from top to bottom and columns are numbered from left to right.

        Problem Constraints
        2 <= N * M <= 20
        -1 <= A[i] <= 2

        Input Format
            The first argument given is the integer matrix A.

        Output Format
            Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

        Example Input
            Input 1:
            A = [   [1, 0, 0, 0]
                    [0, 0, 0, 0]
                    [0, 0, 2, -1]   ]
            Input 2:
            A = [   [0, 1]
                    [2, 0]    ]

        Example Output
            Output 1:
            2
            Output 2:
            0

        Example Explanation
        Explanation 1:
          We have the following two paths:
            1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
            2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

 */
package RecursionAndBackTrackinig;

public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0, 0},{0, 0, 0, 0},{0, 0, 2, -1}  };
        int[][] B = {{0, 1},{2, 0}};
        int[][] C = {{2, -1},{0, 0},{-1, 1}};

        System.out.println(uniquePaths(A));
        System.out.println(uniquePaths(B));
        System.out.println(uniquePaths(C));
    }

    static int z_count = 0, ans = 0, x, y;

    static int uniquePaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        z_count = 0;
        ans = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // Count non-obstacle blocks
                if (grid[i][j] == 0) {
                    vis[i][j] = false;
                    z_count++;
                }
                else if (grid[i][j] == 1) {
                    vis[i][j] = false;
                    x = i;
                    y = j;
                }else if (grid[i][j] == -1) {
                    vis[i][j] = true;
                }
            }
        }
        return dfs(x, y, grid, vis, ans, 0, z_count);
    }

    // Function to return the count of the unique paths
    static int dfs(int i, int j, int[][] grid,boolean[][] vis, int ans, int z, int z_count) {
        int n = grid.length, m = grid[0].length;
        // Mark the block as visited
        vis[i][j] = true;
        if (grid[i][j] == 0)
            // update the count
            z++;

        // If end block reached
        if (grid[i][j] == 2) {
            // If path covered all the non- obstacle blocks
            if (z == z_count) {
                ans++;
            }
            vis[i][j] = false;
            return ans;
        }

        // Up
        if (i >= 1 && !vis[i - 1][j] && grid[i - 1][j] != -1)
            ans = Math.max(ans,dfs(i - 1, j, grid, vis, ans, z, z_count));

        // Down
        if (i < n - 1 && !vis[i + 1][j] && grid[i + 1][j] != -1)
            ans = Math.max(ans,dfs(i + 1, j, grid, vis, ans, z, z_count));

        // Left
        if (j >= 1 && !vis[i][j - 1] && grid[i][j - 1] != -1)
            ans = Math.max(ans,dfs(i, j - 1, grid, vis, ans, z, z_count));

        // Right
        if (j < m - 1 && !vis[i][j + 1] && grid[i][j + 1] != -1)
            ans = Math.max(ans,dfs(i, j + 1, grid, vis, ans, z, z_count));

        // Unmark the block (unvisited)
        vis[i][j] = false;
        return ans;
    }
}
