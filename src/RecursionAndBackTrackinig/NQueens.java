/*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle.
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
    and an empty space respectively.

    Problem Constraints
    1 <= N <= 10

    Input Format
    First argument is an integer n denoting the size of chessboard

    Output Format
    Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

    Example Input
    Input 1:
    n = 4

    Example Output
    Output 1:
    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]

    Example Explanation
    Explanation 1:
    There exist only two distinct solutions to the 4-queens puzzle:

 */

package RecursionAndBackTrackinig;

import java.util.ArrayList;

public class NQueens {
    static ArrayList<ArrayList<String>> res;
    static ArrayList<ArrayList<Boolean>> validateMap;
    static ArrayList<Integer> rows;
    static ArrayList<Integer> cols;
    static int N;

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        // Initialize for new test cases;
        res = new ArrayList<>();
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        N = a;
        // Prepare a boolean map to check feasibility of position
        validateMap = new ArrayList<>();
        for(int i=0; i< N; i++){
            ArrayList<Boolean> negFlags = new ArrayList<>();
            for(int j =0; j< N; j++){
                negFlags.add(false);
            }
            validateMap.add(i, negFlags);
        }

        prepareNQueens(0);
        printList(res);
        return res;
    }

    private static void printList(ArrayList<ArrayList<String>> s1) {
        for (ArrayList<String> strings : s1) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static void prepareNQueens(int row) {
        // Base Case
        if(row == N){
            // Positive base case
            if(cols.size() == N) {
                ArrayList<String> op = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    StringBuilder str = new StringBuilder();
                    for (int j = 0; j < N; j++) {
                        if (cols.get(i) != j) {
                            str.append(".");
                        } else {
                            str.append("Q");
                        }
                    }
                    op.add(str.toString());
                }
                // Appending positive base case to Final result
                res.add(op);
            }
        }else {
            for (int col = 0; col < N; col++) {
                // Check if we can put Queen at (row, col) coordinate
                if (isValid(row, col)) {
                    // Update the landscape
                    rows.add(row);
                    cols.add(row, col);
                    validateMap.get(row).set(col, true);
                    // Recursive Call
                    prepareNQueens(row + 1);
                    // Rollback of landscape
                    cols.remove(row);
                    rows.remove(row);
                    validateMap.get(row).set(col, false);
                }

            }
        }
    }

    // Checking the validity
    private static boolean isValid(int row, int col) {
        // Check for presence of Elements on the left
        int upCol = col-1;
        while(upCol >= 0){
            if(validateMap.get(row).get(upCol)){
                return false;
            }
            upCol--;
        }

        // Check for presence of Elements at above
        int backRow = row-1;
        while(backRow >= 0){
            if(validateMap.get(backRow).get(col)){
                return false;
            }
            backRow--;
        }

        // Check for presence of Elements on the left diagonal
        int leftRow = row-1;
        int leftCol = col-1;
        while(leftCol >= 0 && leftRow >= 0){
            if(validateMap.get(leftRow).get(leftCol)){
                return false;
            }
            leftCol--;
            leftRow--;
        }

        // Check for presence of Elements on the Right Diagonal
        int rightRow = row-1;
        int rightCol = col+1;
        while(rightCol < N && rightRow >= 0){
            if(validateMap.get(rightRow).get(rightCol)){
                return false;
            }
            rightCol++;
            rightRow--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(6));
    }
}
