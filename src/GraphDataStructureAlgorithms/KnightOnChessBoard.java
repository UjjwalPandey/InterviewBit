/*
Knight On Chess Board

Problem Description

Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.

The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints

1 <= A, B <= 500


Input Format

The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.


Output Format

If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.


Example Input

Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8

Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4



Example Output

Output 1:

 6

Output 2:

 -1



Example Explanation

Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.

Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1)
 */
package GraphDataStructureAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(knight(8,8,1,1,8,8));
        System.out.println(knight(2,4,2,1,4,4));
    }

    static int N, M;
    static boolean[] visited;
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

    private static boolean isValid(int x, int y) {
        return (x > 0 && y > 0 && x < N && y < M && !visited[x*M+y]);
    }

    public static int knight(int A, int B, int C, int D, int E, int F) {
        if(C == E && D == F) return 0;
        N = A+1;
        M = B+1;
        visited = new boolean[N*M];
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(C,D,0));
        int[][] dirs={{1, 2} ,{2, 1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}, {1, -2}, {2, -1}};

        while (!queue.isEmpty()){
            Point s = queue.poll();
            for (int[] dir: dirs) {
                int x = s.x + dir[0];
                int y = s.y + dir[1];
                if(x == E && y == F) return s.dist+1;
                if (isValid(x, y)) {
                    queue.add(new Point(x, y, s.dist+1));
                    count = Math.max(count, s.dist+1);
                    visited[x*M+y] = true;
                }
            }
        }
        return -1;
    }
}
