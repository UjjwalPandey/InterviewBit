/*  Maximum XOR of Two Numbers in an Array
    Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where
    i, j are the indexes of the array.

    Input Format
        The only argument given is the integer array A.
    Output Format
        Return the maximum result of A[i] XOR A[j].
    Constraints
        1 <= length of the array <= 100000
        0 <= A[i] <= 10^9
    For Example
    Input 1:
        A = [1, 2, 3, 4, 5]
    Output 1:
        7

    Input 2:
        A = [5, 17, 100, 11]
    Output 2:
        117

Note: Taken Help from https://www.geeksforgeeks.org/maximum-xor-of-two-numbers-in-an-array/
 */
package Bit_Manipulation;

import java.util.*;

public class MaximumXORofTwoNumbersInAnArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A));
        int[] B = { 6, 10, 9, 3, 10, 3, 4, 1, 5, 5, 1, 9, 6, 1, 8, 2, 5, 4, 6, 9, 6};
        System.out.println(solve(B));
    }


    public static int solve(int[] A) {
        int maxx = 0, mask = 0;

        HashSet<Integer> se = new HashSet<Integer>();

        for (int i = 30; i >= 0; i--) {

            // set the i'th bit in mask
            // like 100000, 110000, 111000..
            mask |= (1 << i);

            for (int j = 0; j < A.length; ++j) {

                // Just keep the prefix till
                // i'th bit neglecting all
                // the bit's after i'th bit
                se.add(A[j] & mask);
            }

            int newMaxx = maxx | (1 << i);

            for (int prefix : se)
            {

                // find two pair in set
                // such that a^b = newMaxx
                // which is the highest
                // possible bit can be obtained
                if (se.contains(newMaxx ^ prefix))
                {
                    maxx = newMaxx;
                    break;
                }
            }

            // clear the set for next
            // iteration
            se.clear();
        }
        return maxx;
    }
}
