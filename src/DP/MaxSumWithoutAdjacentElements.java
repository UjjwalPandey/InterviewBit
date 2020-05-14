/*  Max Sum Without Adjacent Elements

Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.



Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000


Input Format

The first and the only argument of input contains a 2d matrix, A.


Output Format

Return an integer, representing the maximum possible sum.


Example Input

Input 1:

 A = [
        [1]
        [2]
     ]

Input 2:

 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]



Example Output

Output 1:

 2

Output 2:

 8



Example Explanation

Explanation 1:

 We will choose 2.

Explanation 2:

 We will choose 3 and 5.

 */
package DP;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {2, 3, 4, 5}};
        System.out.println(adjacent(A));

        int[][] B = {{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},
                {31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};  // 321
        System.out.println(adjacent(B));
    }

    public static int adjacent(int[][] A) {
        if(A.length == 0) return 0;

        int inc = 0, exc = 0;

        for(int i = 0; i < A[0].length; i++){
            int num = Math.max(A[0][i], A[1][i]);
            int temp = Math.max(exc, inc);

            inc = exc + num;
            exc = temp;
//            System.out.println(A[0][i]+"  "+A[1][i]+"  "+exc+"  "+inc);
        }


        return Math.max(inc, exc);
    }
}
