/*  0-1 Knapsack

    Problem Description
        Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
        Also given an integer C which represents knapsack capacity.
        Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
    NOTE:
        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



    Problem Constraints

    1 <= N <= 103

    1 <= C <= 103

    1 <= A[i], B[i] <= 103



    Input Format

    First argument is an integer array A of size N denoting the values on N items.

    Second argument is an integer array B of size N denoting the weights on N items.

    Third argument is an integer C denoting the knapsack capacity.



    Output Format

    Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.


    Example Input

    Input 1:

     A = [60, 100, 120]
     B = [10, 20, 30]
     C = 50

    Input 2:

     A = [10, 20, 30, 40]
     B = [12, 13, 15, 19]
     C = 10



    Example Output

    Output 1:

     220

    Output 2:

     0



    Example Explanation

    Explanation 1:

     Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220

    Explanation 2:

     Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
package DP;

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;
        System.out.println(knapsack(A,B,C));  // 220
        System.out.println(recurrenceKnapsack(A,B,C, 0));  // 220
        int[] D = {468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323};
        int[] E = {4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1, 10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7 };
        int F = 841;
        System.out.println(knapsack(D, E, F));  // 24576
    }



    // Solution for 10^8 time complexity
    // Using DP
    // Element of choice: Either include or exclude the element.
    public static int knapsack(int[] vals, int[] wt, int C) {
        int[][] dp = new int[vals.length+1][C+1];
        // Till ith element of Knapsack with weight j, dp[i][j] represent max profit till ith elem considering TW as j.
        for(int i=1; i <= vals.length; i++){
            for(int j=1; j <= C; j++){
                int include = -1;
                if(j >= wt[i-1]){
                    include = dp[i-1][j-wt[i-1]]+vals[i-1];
                }
                dp[i][j] = Math.max(dp[i-1][j], include );
            }
        }
        printArray(dp);
        return dp[vals.length][C];
    }



    // Solution for 10^9 time complexity
    // Thus considering n terms of Vals[i]
    public static int knapsack2(int[] vals, int[] wt, int C) {
        int[][] dp = new int[vals.length+1][C+1];
        // Till ith element of Knapsack with weight j, dp[i][j] represent max profit till ith elem considering TW as j.
        for(int i=1; i <= vals.length; i++){
            for(int j=1; j <= C; j++){
                int include = -1;
                if(j >= vals[i-1]){
                    include = dp[i-1][j-vals[i-1]];
                }
                dp[i][j] = Math.max(dp[i-1][j], include );
            }
        }
        return dp[vals.length][C];
    }




    // Recursive Solution  -- Not Time Optimal
    private static int recurrenceKnapsack(int[] vals, int[] wt,int TW, int i) {
        if(i == vals.length-1) return (TW >= wt[i])?vals[i]:0;
        int included = Integer.MIN_VALUE;
        if(wt[i] <= TW){
            included = vals[i] + recurrenceKnapsack(vals, wt,TW-wt[i], i+1);
        }
        return Math.max(included, recurrenceKnapsack(vals, wt, TW, i+1));
    }


    private static void printArray(int[][] dp) {
        for(int[] arr: dp) {
            for (int x : arr) System.out.print(x + ", ");
            System.out.println();
        }
    }
}
