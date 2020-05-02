/*  https://www.geeksforgeeks.org/number-ways-form-heap-n-distinct-integers/

Ways to form Max Heap
    Problem Description

    Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes.

    Find the number of distinct Max Heap can be made from A distinct integers.

    In short, you have to ensure the following properties for the max heap :

        Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
        Every node is greater than all its children.

    NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.



    Problem Constraints

    1 <= A <= 100


    Input Format

    First and only argument is an inetegr A.


    Output Format

    Return an integer denoting the number of distinct Max Heap.


    Example Input

    Input 1:

     A = 4

    Input 2:

     A = 10



    Example Output

    Output 1:

     3

    Output 2:

     3360

 */

package Heaps;

public class WaysToFormMaxHeap {
    public static void main(String[] args) {
        System.out.println(solve(10));
        System.out.println(solve(20));
        System.out.println(solve(99));
    }
    static int MAXN = 105; // maximum value of n here

    static int MOD = 1000000007;

    // dp[i] = number of max heaps for i distinct integers
    static int[] dp = new int[MAXN];

    // nck[i][j] = number of ways to choose j elements
    //         form i elements, no order */
    static long[][] nck = new long[MAXN][MAXN];

    // log2[i] = floor of logarithm of base 2 of i
    static int[] log2 = new int[MAXN];

    // to calculate nCk
    public static long choose(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (k == 0) {
            return 1;
        }
        if (nck[n][k] != -1) {
            return nck[n][k];
        }

        long answer = (choose(n - 1, k - 1) + choose(n - 1, k))%MOD;
        nck[n][k] = answer;
        return answer;
    }

    // calculate l for give value of n
    public static int getLeft(int n) {
        if (n == 1) {
            return 0;
        }

        int h = log2[n];
        // max number of elements that can be present in the
        // hth level of any heap
        int numh = (1 << h); //(2 ^ h)
        // number of elements that are actually present in
        // last level(hth level)
        // (2^h - 1)
        int last = n - ((1 << h) - 1);
        // if more than half-filled
        if (last >= (numh / 2)) {
            return (1 << h) - 1; // (2^h) - 1
        }
        else {
            return (1 << h) - 1 - ((numh / 2) - last);
        }
    }

    // find maximum number of heaps for n
    public static int numberOfHeaps(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = getLeft(n);
        long ans = ((choose(n - 1, left) * numberOfHeaps(left))%MOD
                * (numberOfHeaps(n - 1 - left)))%MOD;
        dp[n] = (int)ans%MOD;
        return (int)ans%MOD;
    }

    // function to initialize arrays

    private static int solve(int A) {
        for (int i = 0; i <= A; i++) {
            dp[i] = -1;
            for (int j = 0; j <= A; j++) {
                nck[i][j] = -1;
            }
        }
        int currLog2 = -1;
        int currPower2 = 1;

        // for each power of two find logarithm
        for (int i = 1; i <= A; i++) {
            if (currPower2 == i) {
                currLog2++;
                currPower2 *= 2;
            }
            log2[i] = currLog2;
        }
        return numberOfHeaps(A);
    }
}
