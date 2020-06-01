/*
Rotten Oranges

Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.


Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.


Example Input

Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]

Input 2:


A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]



Example Output

Output 1:

 4

Output 2:

 -1



Example Explanation

Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)

Explanation 2:

 Task is impossible

 */
package GraphDataStructureAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] A = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int[][] B = new int[][]{{2,1,1},{0, 1,1},{1,0,1}};
        printArr(A);
        System.out.println(rottenOranges(A));
        printArr(A);
        printArr(B);
        System.out.println(rottenOranges(B));
        printArr(B);
    }

    static int N, M;
    static class Point{

        int x, y, dist;
        public Point(int a, int b){
            x = a;
            y = b;
            dist = 0;
        }
        public Point(int a, int b, int c){
            x = a;
            y = b;
            dist = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dist=" + dist +
                    '}';
        }
    }

    private static boolean isValid(int x, int y, int[][] A) {
        if(x >= 0 && y >= 0 && x < N && y < M ){
            return (A[x][y] == 1);
        }
        return false;
    }
    public static int rottenOranges(int[][] A) {
        N = A.length;
        M = A[0].length;
        int count = 0;
        Queue<Point> twos = new LinkedList<>();
        for(int i=0; i< N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j] == 2){
                    twos.add(new Point(i,j));
                }
            }
        }
        for(Point p: twos) System.out.println(p.toString());
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};

        while (!twos.isEmpty()){
            Point s = twos.poll();
            for (int[] dir: dirs) {
                int x = s.x + dir[0];
                int y = s.y + dir[1];
                if (isValid(x, y, A)) {
                    A[x][y] = 2;
                    twos.add(new Point(x, y, s.dist+1));
                    count = Math.max(count, s.dist+1);
                }
            }
        }
        for(int[] arr: A){
            for(int x: arr) if(x == 1) return -1;
        }
        return count;
    }

    private static void printArr(int[][] res1) {
        for(int[] arr: res1){
            for(int x: arr) System.out.print(x+", ");
            System.out.println();
        }
        System.out.println();
    }
}
