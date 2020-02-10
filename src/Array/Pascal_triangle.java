/** Given numRows, generate the first numRows of Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Given numRows = 5,

 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 *
 *
 */
package Array;

public class Pascal_triangle {
    private static int max = 0;
    public static void main(String[] args) {
        int N = 5;
        int[][] res = pascalTriangle(N);
        for (int r=0; r<res.length; r++) {
            for (int c=0; c<res[r].length; c++) {
                System.out.print(" "+res[r][c]);
            }
            System.out.println();
        }
}

    private static int[][] pascalTriangle(int ROW) {
        int [][] tri = new int[ROW][];

        for (int r=0; r<tri.length; r++) {
            tri[r] = new int[r+1];  // <-- This line is the hack in this question. As this will give Rows of variable length.
            tri[r][0] = 1;
            tri[r][r] = 1;
            for (int c=1; c<r; c++) {
                tri[r][c] = tri[r-1][c]+tri[r-1][c-1];
            }
        }
        return tri;
    }
}
