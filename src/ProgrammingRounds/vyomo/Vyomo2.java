/*
    Write a program to print fibonacci series without using loops
    0-1-1-2-3-5-8-
 */
package ProgrammingRounds.vyomo;

import java.util.ArrayList;
import java.util.Collections;

public class Vyomo2 {
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        res = new ArrayList<>();
        fibonacci(14);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void printFibonacci(int N) {

    }


    private static int fibonacci( int N) {
//        if(curr )
        if(N == 0){
            System.out.println(0);
            return 0;
        }
        if(N == 1){
            System.out.println(1);
            return 0;
        }
        if(N == 2){
            System.out.println(1);
            return 1;
        }
        int res = fibonacci(N-1)+fibonacci(N-2);
        System.out.println(res);
        return res;
    }
}


/*

3, 7, 2, 4, 9, 1

 */