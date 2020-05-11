/*

Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]

Output:

1

Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

 */
package TwoPointers;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        int[] A = { 1, 4, 5, 8, 10 };
        int[] B = { 6, 9, 15 };
        int[] C = { 2, 3, 6, 6 };

        System.out.println(solve(A,B,C));

    }
    public static int solve(int[] A, int[] B, int[] C) {
        int i1 =0, i2 =0, i3 =0;
        int min = Integer.MAX_VALUE;
        while (i1 < A.length && i2< B.length && i3 < C.length ){
            int minEle = Math.min(A[i1], Math.min(B[i2] , C[i3]));
            min = Math.min(min,Math.abs(Math.max(A[i1], Math.max(B[i2] , C[i3])) - minEle));
//            System.out.println(min+"   "+minEle+"   "+A[i1]+"   "+B[i2]+"   "+C[i3]);
            if(minEle == A[i1]){
                i1++;
            }else if(minEle == B[i2]){
                i2++;
            }else if(minEle == C[i3]){
                i3++;
            }
        }
        return min;
    }
}
