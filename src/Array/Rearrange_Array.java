/** Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

 Example:

 Input : [1, 0]
 Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
 All elements in the array are in the range [0, N-1]
 N * N does not overflow for a signed integer
 *
 */


/** SOLUTION APPROACH:
 * If you had extra space to do it, the problem will be very easy.
 * Store a copy of Arr in B.
 *
 * And then for every element, do Arr[i] = B[B[i]]
 *
 * Lets restate what we just said for extra space :
 *
 * If we could somehow store 2 numbers in every index ( that is, Arr[i] can contain the old value and the new value somehow ), then the problem becomes very easy.
 * NewValue of Arr[i] = OldValue of Arr[OldValue of Arr[i]]
 *
 * Now, we will do a slight trick to encode 2 numbers in one index.
 * This trick assumes that N * N does not overflow.
 *
 * 1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
 * 2) Divide every element by n.
 * Given a number as
 *
 *    A = B + C * N   if ( B, C < N )
 *    A % N = B
 *    A / N = C
 * We use this fact to encode 2 numbers into each element of Arr.
 *
 */
package Array;

import java.util.ArrayList;

public class Rearrange_Array {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0,1);
        A.add(1,3);
        A.add(2,4);
        A.add(3,0);
        A.add(4,5);
        A.add(5,2);

        System.out.println(A);
        arrange(A);
        System.out.println(A);
    }
    public static void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
    }
}
