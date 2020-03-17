/*  3 Sum

    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers.

    Assume that there will only be one solution

    Example: given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

 */
package TwoPointers;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        int B = 1;
        System.out.println(threeSumClosest(A,B));

        int[] C = {-10, -10, -10};
        int D = -5;
        System.out.println(threeSumClosest(C, D));

        int[] E = {2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };
        int F = -1;
        System.out.println(threeSumClosest(E,F));
    }

    public static int threeSumClosest(int[] A, int B) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0; i< A.length-2; i++){
            int first = A[i];
            int start = i+1, end = A.length-1;
            while (start < end){
                int sum = first + A[start] + A[end];
                int diff = Math.abs(sum - B);
                if (diff == 0) {
                    return B;
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if(sum <= B) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        return res;
    }
}
