/*
Capture Regions on Board

Problem Description

Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Problem Constraints

1 <= N, M <= 1000


Input Format

First and only argument is a N x M character matrix A.


Output Format

Make changes to the the input only as matrix is passed by reference.


Example Input

Input 1:

 A = [
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X]
     ]

Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]



Example Output

Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]

Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]



Example Explanation

Explanation 1:

 O in (4,2) is not surrounded by X from below.

Explanation 2:

 No O's are surrounded.


 */
package GraphDataStructureAlgorithms;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        ArrayList<Character> row = new ArrayList<>();
        row.add('X');
        row.add('X');
        row.add('X');
        row.add('X');
        A.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('O');
        row.add('O');
        row.add('X');
        A.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('X');
        row.add('O');
        row.add('X');
        A.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('O');
        row.add('X');
        row.add('X');
        A.add(row);
        System.out.println(A);
        solve(A);
        System.out.println(A);

        ArrayList<ArrayList<Character>> B = new ArrayList<>();
        row = new ArrayList<>();
        row.add('X');
        row.add('O');
        row.add('O');
        B.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('O');
        row.add('X');
        B.add(row);
        row = new ArrayList<>();
        row.add('O');
        row.add('O');
        row.add('O');
        B.add(row);
        System.out.println(B);
        solve(B);
        System.out.println(B);

        ArrayList<ArrayList<Character>> C = new ArrayList<>();
        row = new ArrayList<>();
        row.add('X');
        row.add('X');
        row.add('X');
        C.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('O');
        row.add('X');
        C.add(row);
        row = new ArrayList<>();
        row.add('X');
        row.add('X');
        row.add('X');
        C.add(row);
        System.out.println(C);
        solve(C);
        System.out.println(C);

    }

    static int N, M;

    public static void solve(ArrayList<ArrayList<Character>> a) {
        M = a.size();
        N = a.get(0).size();
        for(int i=0; i< M; i++){
            for(int j=0; j<N; j++){
                if(a.get(i).get(j) == 'O'){
                    a.get(i).set(j, '-');
                }
            }
        }
        for (int i = 0; i < M; i++) // Left side
            if (a.get(i).get(0) == '-') captureRegionUtil(a, i, 0, '-', 'O');
        for (int i = 0; i < M; i++) // Right side
            if (a.get(i).get(N - 1) == '-') captureRegionUtil(a, i, N - 1, '-', 'O');
        for (int i = 0; i < N; i++) // Top side
            if (a.get(0).get(i) == '-') captureRegionUtil(a, 0, i, '-', 'O');
        for (int i = 0; i < N; i++) // Bottom side
            if (a.get(M-1).get(i) == '-') captureRegionUtil(a, M - 1, i, '-', 'O');

        // Step 3: Replace all '-' with 'X'
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (a.get(i).get(j) == '-')
                    a.get(i).set(j,'X');
    }

    static void captureRegionUtil(ArrayList<ArrayList<Character>> mat, int x, int y, char prevV, char newV) {
        if (x < 0 || x >= M || y < 0 || y >= N)
            return;
        if (mat.get(x).get(y) != prevV)
            return;
        mat.get(x).set(y, newV);
        captureRegionUtil(mat, x + 1, y, prevV, newV);
        captureRegionUtil(mat, x - 1, y, prevV, newV);
        captureRegionUtil(mat, x, y + 1, prevV, newV);
        captureRegionUtil(mat, x, y - 1, prevV, newV);
    }
}
