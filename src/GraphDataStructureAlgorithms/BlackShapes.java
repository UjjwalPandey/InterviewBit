/*
Black Shapes

Problem Description

Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Problem Constraints

1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'



Input Format

The First and only argument is character matrix A.


Output Format

Return a single integer denoting number of black shapes.


Example Input

Input 1:

 A = [ [X, X, X], [X, X, X], [X, X, X] ]

Input 2:

 A = [ [X, O], [O, X] ]



Example Output

Output 1:

 1

Output 2:

 2



Example Explanation

Explanation 1:

 All X's belong to single shapes

Explanation 2:

 Both X's belong to different shapes

 */
package GraphDataStructureAlgorithms;

public class BlackShapes {
    public static void main(String[] args) {
        System.out.println(black(new String[]{"XXX","XXX","XXX"}));
        System.out.println(black(new String[]{"XO","OX"}));
    }

    public static int black(String[] A) {
        if(A.length == 0){
            return 0;
        }
        int[][] check = new int[A.length][A[0].length()];
        boolean[][] visited = new boolean[A.length][A[0].length()];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length(); j++){
                if(A[i].charAt(j) == 'X'){
                    check[i][j] = 1;
                }
            }
        }
        int sol = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++){
                if(A[i].charAt(j) == 'X' && !visited[i][j]){
                    dfs(A, i, j, visited, check);
                    sol++;
                }
            }
        }

        return sol;
    }


    static void dfs(String[] A, int i, int j, boolean[][] visited, int[][] check){
        if(i < 0 || i >= A.length){
            return;
        }
        if(j < 0 || j >= A[0].length()){
            return;
        }
        if(check[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(A, i-1, j, visited, check);
        dfs(A, i+1, j, visited, check);
        dfs(A, i, j-1, visited, check);
        dfs(A, i, j+1, visited, check);
    }
}
