/*  Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
    It is allowed to swap any two elements (not necessarily consecutive).
    Find the minimum number of swaps required to sort the array in ascending order.

    Input Format
        The only argument given is the integer array A.
    Output Format
        Return the minimum number of swaps.
    Constraints
        1 <= N <= 100000
        0 <= A[i] < N
    For Example
        Example Input 1:
            A = [1, 2, 3, 4, 0]
        Example Output 1:
            4
        Explanation:
            You cannot sort it with lesser swaps
        Example Input 2:
            A = [2, 0, 1, 3]
        Example Output 2:
            2

 */
package Sorting;

public class MinimumSwaps2 {
    public static void main(String[] args) {
        System.out.println(minSwap(new int[]{1,2,3,4,0}));
    }

    private static int minSwap(int[] A) {
        int count = 0;
        int i = 0;
        while (i < A.length) {
            // If current element is 
            // not at the right position 
            if (A[i] != i) {
                while (A[i] != i) {
                    int temp;
                    // Swap current element 
                    // with correct position 
                    // of that element 
                    temp = A[A[i]];
                    A[A[i]] = A[i];
                    A[i] = temp;
                    count++;
                }
            }
            // Increment for next index 
            // when current element is at 
            // correct position 
            i++;
        }
        return count;
    }
}
