/*  Stairs

Problem Description

You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Problem Constraints

1 <= A <= 36


Input Format

The first and the only argument contains an integer A, the number of steps.


Output Format

Return an integer, representing the number of ways to reach the top.


Example Input

Input 1:

 A = 2

Input 2:

 A = 3



Example Output

Output 1:

 2

Output 2:

 3



Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].

Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].

 */
package DP;

public class Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(30));
        System.out.println(climbStairsBottomUp(30));
    }

    // Top-Down Approach == Recursive
    private static int climbStairs(int N) {
        if(N < 1) return 0;
        switch (N){
            case 1: return 1;
            case 2: return 2;
            default: return climbStairs(N-1)+climbStairs(N-2);
        }
    }


    // Bottom-Up Approach == Iterative
    private static int climbStairsBottomUp(int N) {
        if(N < 1) return 0;
        int[] DP = new int[N+1];
        DP[1] = 1;
        DP[2] = 2;
        for(int i=3; i<= N; i++){
            DP[i] = DP[i-1]+DP[i-2];
        }
        return DP[N];
    }
}
