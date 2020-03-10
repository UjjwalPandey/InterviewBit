package RecursionAndBackTrackinig;

import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {
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
        solveSudoku(s1);
        // Print Solution
        printList(s1);
    }

    private static void printList(ArrayList<ArrayList<Character>> s1) {
        for(int i =0; i< s1.size(); i++) {
            for (int j = 0; j < s1.get(i).size(); j++) {
                System.out.print(s1.get(i).get(j)+"  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

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

    static  ArrayList<HashSet<Integer>> blocks = new ArrayList<>();
    static  ArrayList<HashSet<Integer>> rows = new ArrayList<>();
    static  ArrayList<HashSet<Integer>> cols = new ArrayList<>();
    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
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

        for(int i = 0; i <= 8; i++) {
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

        prepareSudoku(a,0,0,1,0,emptyFields,rows,cols,blocks);
    }

   private static void prepareSudoku(ArrayList<ArrayList<Character>> a, int x, int y, int candidateVal, int currEmpty, int emptyFields, ArrayList<HashSet<Integer>> rows, ArrayList<HashSet<Integer>> col, ArrayList<HashSet<Integer>> blocks) {
        System.out.println(x + "  " + y + "  CurrEmpty  " + currEmpty+"  Empty Fields  = "+emptyFields);
        if (currEmpty == emptyFields) {
            boolean isRowFilled = true, isColFilled = true, isBlockFilled = true;
            for (int i = 0; i < 9; i++) {
                if (rows.get(i).size() != 9) isRowFilled = false;
                if (col.get(i).size() != 9) isColFilled = false;
                if (blocks.get(i).size() != 9) isBlockFilled = false;
            }
            if (isRowFilled && isColFilled && isBlockFilled) {
                printList(a);
                return;
            }
        }

        char ch = a.get(x).get(y);
        int nextPossibility = candidateVal, positionEmpty = 0;
        if (ch == '.') {
            positionEmpty = 1;
        }
        printList(a);
        while(nextPossibility != -1) {
            System.out.println("Next Poss =  "+nextPossibility);
            int blockNum = findBlockNumber(x, y);
            nextPossibility = findNext(rows.get(x), col.get(y), blocks.get(blockNum - 1), nextPossibility);
            if(nextPossibility == -1) return;
            if(positionEmpty == 1) {
                System.out.println("X = " + x + "  Y = " + y + "  BlockNum =  " + blockNum + " Next Possible =  " + nextPossibility);
                a.get(x).set(y, (char) (nextPossibility + '0'));
                rows.get(x).add(nextPossibility);
                col.get(y).add(nextPossibility);
                blocks.get(blockNum - 1).add(nextPossibility);
            }
            if (y < a.get(x).size() - 1)
                prepareSudoku(a, x, y + 1, nextPossibility, currEmpty + positionEmpty, emptyFields, rows, col, blocks);
            else {
                prepareSudoku(a, x + 1, 0, nextPossibility, currEmpty + positionEmpty, emptyFields, rows, col, blocks);
            }
            if(positionEmpty == 1) {
                rows.get(x).remove(nextPossibility);
                col.get(y).remove(nextPossibility);
                blocks.get(blockNum).remove(nextPossibility);
            }
        }
        System.out.println("End of Function");
    }

    private static int findNext(HashSet<Integer> rows, HashSet<Integer> cols, HashSet<Integer> blocks,int val) {
        for(int i=val; i<=9; i++) {
            if (!rows.contains(i) && !cols.contains(i) && !blocks.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
