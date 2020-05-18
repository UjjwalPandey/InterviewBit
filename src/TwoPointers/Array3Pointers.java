/*   Array 3 Pointers

Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[p1] - B[p2]), abs(B[p2] - C[p3]), abs(C[p3] - A[p1])) is minimized.

Return the minimum max(abs(A[p1] - B[p2]), abs(B[p2] - C[p3]), abs(C[p3] - A[p1])).



Problem Constraints

0 <= len(A), len(B), len(c) <= 106

0 <= A[p1], B[p1], C[p1] <= 107



Input Format

First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format

Return an single integer denoting the minimum max(abs(A[p1] - B[p2]), abs(B[p2] - C[p3]), abs(C[p3] - A[p1])).


Example Input

Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]

Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]



Example Output

Output 1:

 5

Output 2:

 1



Example Explanation

Explanation 1:

 With 10 from A, 15 from B and 10 from C.

Explanation 2:

 With 3 from A, 2 from B and 3 from C.

 */
package TwoPointers;

public class Array3Pointers {
    public static void main(String[] args) {
        int[] A = {1, 4, 10};
        int[] B = {2, 15, 20};
        int[] C = {10, 12};
        System.out.println(minimize(A, B, C));
    }

    public static int minimize(final int[] A, final int[] B, final int[] C) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int ans = Integer.MAX_VALUE;

        while (p1<A.length && p2<B.length && p3<C.length) {
            int minVal = Math.min(A[p1], Math.min(B[p2], C[p3]));
            int maxVal = Math.max(A[p1], Math.max(B[p2], C[p3]));

            if (ans > maxVal - minVal) {
                ans = maxVal - minVal;
            }

            if (minVal == A[p1]) p1++;
            else if (minVal == B[p2]) p2++;
            else p3++;
        }

        return ans;
    }
}
