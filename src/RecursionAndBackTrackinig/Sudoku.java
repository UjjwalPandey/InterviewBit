/*  Write a program to solve a Sudoku puzzle by filling the empty cells.
    Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
    A sudoku puzzle,   and its solution numbers marked in red.

    Problem Constraints
    1 <= N <= 9

    Input Format
        First argument is an array of array of characters representing the Sudoku puzzle.

    Output Format
        Modify the given input to the required answer.

    Example Input
        Input 1:
            A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

    Example Output
        Output 1:
            [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

    Example Explanation
        Explanation 1:
            Look at the diagrams given in the question.

 */
package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {
    static  ArrayList<HashSet<Integer>> blocks;
    static  ArrayList<HashSet<Integer>> rows;
    static  ArrayList<HashSet<Integer>> cols;
    static ArrayList<ArrayList<Character>> result;

    private static void printList(ArrayList<ArrayList<Character>> s1) {
        for (ArrayList<Character> characters : s1) {
            for (Character character : characters) {
                System.out.print(character + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Finding the block(1-9) for a given coordinate.

    private static int findBlockNumber(int i, int j) {
        if(i < 3){
            if(j < 3){
                return 1;
            }else if(j < 6){
                return 2;
            }else{
                return 3;
            }
        }else if(i < 6){
            if(j < 3){
                return 4;
            }else if(j < 6){
                return 5;
            }else{
                return 6;
            }
        }else{
            if(j < 3){
                return 7;
            }else if(j < 6){
                return 8;
            }else{
                return 9;
            }
        }
    }
    // Filling up the vales of Blocks, Rows, Column ArrayLists.

    public static ArrayList<ArrayList<Character>> solveSudoku(ArrayList<ArrayList<Character>> a) {
        blocks = new ArrayList<>();
        rows = new ArrayList<>();
        cols = new ArrayList<>();

        int emptyFields = 0;

        for(int i =0; i< a.size(); i++){
            HashSet<Integer> colHS = new HashSet<>();
            HashSet<Integer> rowHS = new HashSet<>();
            for(int j=0; j < a.get(i).size(); j++){
                char rowCh = a.get(i).get(j);
                char colCh = a.get(j).get(i);
                if(rowCh != '.')
                    rowHS.add(rowCh-'0');
                if(colCh != '.')
                    colHS.add(colCh-'0');
            }
            rows.add(rowHS);
            cols.add(colHS);
        }

        for(int i = 0; i < 9; i++) {
            blocks.add(new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9 ; j++){
                int blockNo = findBlockNumber(i,j);
                char blockCh = a.get(i).get(j);
                if(blockCh != '.')
                    blocks.get(blockNo-1).add(blockCh-'0');
                else emptyFields++;
            }
        }

        prepareSudoku(a,0,0,  0, emptyFields);
        return a;
    }
   private static int prepareSudoku(ArrayList<ArrayList<Character>> a, int x, int y, int emptyCounts, int totalEmptyFields) {
        // BASE CASE: When all fields are filled.
        if(emptyCounts == totalEmptyFields){
           result = new ArrayList<>(a);
           return 1;
       }
       char ch = a.get(x).get(y);
       int resultType;
       // If position not empty then move to next vacant position
       if(ch != '.'){
            if(y == a.size()-1) {
                resultType = prepareSudoku(a,x+1,0,  emptyCounts, totalEmptyFields);
            }
            else {
                resultType = prepareSudoku(a,x,y+1,  emptyCounts, totalEmptyFields);
            }
            if(resultType == 1) return resultType;
       }else{
           // Vacant position
            for(int possibleNum = 1; possibleNum <= 9; possibleNum++) {
                // Check if the number suits the condition
                if(isValid(rows.get(x), cols.get(y), blocks.get(findBlockNumber(x, y) - 1), possibleNum)) {
                    // DO the changes
                    a.get(x).set(y, (char) (possibleNum + '0'));
                    rows.get(x).add(possibleNum);
                    cols.get(y).add(possibleNum);
                    blocks.get(findBlockNumber(x, y) - 1).add(possibleNum);
                    // Recursion with next position
                    if (y == a.size() - 1) {
                        resultType = prepareSudoku(a, x + 1, 0, emptyCounts + 1, totalEmptyFields);
                    } else {
                        resultType = prepareSudoku(a, x, y + 1, emptyCounts + 1, totalEmptyFields);
                    }
                    // If Sudoku solved(i.e. Return type == 1) the simply return the formed List
                    if(resultType == 1) return resultType;
                    // Else Roll back to earlier version.
                    a.get(x).set(y, '.');
                    rows.get(x).remove(possibleNum);
                    cols.get(y).remove(possibleNum);
                    blocks.get(findBlockNumber(x, y) - 1).remove(possibleNum);
                }
            }
        }
       // Sudoku not solved yet.
       return 0;
   }

   // Checking if given value 'val' satisfies the Sudoku condition.

    private static boolean isValid(HashSet<Integer> rows, HashSet<Integer> cols, HashSet<Integer> blocks,int val) {
            return (!rows.contains(val) && !cols.contains(val) && !blocks.contains(val));
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> s1 = new ArrayList<>();
        String[] str = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        for(String s: str){
            char[] c = s.toCharArray();
            ArrayList<Character> charList = new ArrayList<>();
            for(char ch: c){
                charList.add(ch);
            }
            s1.add(charList);
        }
        // Print the question
        printList(s1);
        result = solveSudoku(s1);
        // Print Solution
        printList(result);
    }
}
