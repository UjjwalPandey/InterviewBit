/*
Valid Path

Problem Description

There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints

0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).


Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]

Input 2:

 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]



Example Output

Output 1:

 NO

Output 2:

 NO



Example Explanation

Explanation 1:

 There is NO valid path in this case

Explanation 2:

 There is NO valid path in this case

 */
package GraphDataStructureAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {
    public static void main(String[] args) {
        System.out.println(solve(2,3,1,1,new int[]{1},new int[]{1}));
        System.out.println(solve(2,3,0,0,new int[]{},new int[]{}));
        System.out.println(solve(2,3,1,1,new int[]{2},new int[]{3}));
        System.out.println(solve(1,1,1,1,new int[]{0},new int[]{0}));
    }

    static class Point{
        int x, y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static String solve(int x, int y, int N, int R, int[] A, int[] B) {
        if(x == 0 && y == 0) return "YES";
        int[][] mat = new int[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int p = 0; p < N; p++) {
                    if (Math.sqrt((Math.pow((A[p] - i), 2) + Math.pow((B[p]  - j), 2))) <= R) {
                        mat[x-i][j] = -1;
                    }
                }
            }
        }
//        printArr(mat);
        int[][] move = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1}, {-1,1}, {-1,-1}, {1,-1}};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, 0));
        if(mat[x][0] != 0) return "NO";
        while (!q.isEmpty()){
            Point p = q.poll();
            for(int[] step: move){
                int i = p.x+ step[0];
                int j = p.y + step[1];
                if(isValid(x,y,i,j, mat)){
                    if(i == 0 && j == y) return "YES";
                    mat[i][j] = 1;
                    q.add(new Point(i,j));
                }
            }
        }
//        printArr(mat);
        return "NO";
    }

    private static boolean isValid(int x, int y, int i, int j, int[][] mat) {
        if(i >= 0 && i <= x && j >= 0 && j <= y){
            return (mat[i][j] == 0);
        }
        return false;
    }

    private static void printArr(int[][] res1) {
        for(int[] arr: res1){
            for(int x: arr) System.out.print(x+", ");
            System.out.println();
        }
        System.out.println();
    }
}
