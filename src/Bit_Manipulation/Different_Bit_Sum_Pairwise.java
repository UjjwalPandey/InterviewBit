/*
PROBLEM:  We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
    For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111,respectively.
    The first and the third bit differ, so f(2, 7) = 2.
    You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N.
    Return the answer modulo 10^9+7.

Example Input
A = [1, 3, 5]

Example Output
8

Example Explanation
f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0


Solution:   O(n) time. using the fact that all numbers are represented using 32 bits (or some fixed number of bits).
    * count differences at individual bit positions. We traverse from 0 to 31 and count numbers with i’th bit set.
    * Let this count be ‘count’. There would be “n-count” numbers with i’th bit not set.
    * So count of differences at i’th bit would be “count * (n-count) * 2”,
    the reason for this formula is as every pair having one element which has set bit at i’th position and second element having unset bit at i’th position contributes exactly 1 to sum,
    therefore total permutation count will be count*(n-count) and multiply by 2 is due to one more repetition of all this type of pair as per given condition for making pair 1<=i,j<=N.
 */
package Bit_Manipulation;

public class Different_Bit_Sum_Pairwise {
    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        System.out.println(cntBits(A));
    }

    public static int cntBits(int[] A) {
        int[] nSetBits = new int[31];
        for (int i = 0; i < A.length; i ++) {
            int val = A[i];
            for (int j = 0; j < 32; j ++) {
                if (((val >> j) & 1) == 1) {
                    nSetBits[j]++;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < nSetBits.length; i ++) {
            sum += (long) nSetBits[i] * (A.length - nSetBits[i]) * 2;
        }
        return (int) (sum % 1000000007);
    }
}
