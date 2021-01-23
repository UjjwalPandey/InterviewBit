/*
Write a program to get this pattern. If input array is sent.
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
 */

package ProgrammingRounds.vyomo;

public class Vyomo {
    public static void main(String[] args) {
        printPattern(15);
    }

    private static void printPattern(int N) {
        int row = 1;
        for(int i=1; i<= N;){
            int count =0;
            while(count < row) {
                System.out.print(i + " ");
                count++;
                i++;
            }
            System.out.println();
            row++;
        }
    }
}
