/*
    Count of Range Sum

Problem Description
Given an array of integers A and two integers B and C. Find the number of range sums that lie in [B, C ] inclusive.

Range sum S(i, j) is defined as the sum of the elements in A between indices i and j (i ≤ j), inclusive.



Problem Constraints

1 <= length of the array <= 50000

-109 <= A[i] <= 109



Input Format

First argument is an integer array A.
Second argument is an integer B.
Third argument is an integer C.


Output Format

Find the number of range sums that lie in [B, C ] inclusive.


Example Input

A = [1, 2, 3]
B = 4
C = 6



Example Output

2



Example Explanation

Range Sum that lie between 4 and 6 are 6(1+2+3) and 5(2+3).
 */
package Array;

import java.util.Arrays;

public class CountOfRangeSum {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3},4,6));  // 2
        System.out.println(solve(new int[]{11, 436, 126, -350, 149, 342, 302, -56, 278, -302, 49, -246, 202, 68, -443, -276, 465, 414, -66, 117, 130, -381, 100, -367, -479, 91, -44, -416, -164 },-397,-284));  // 19
        System.out.println(solve(new int[]{ -353, -245, -55, 450, -224, -194, 3, 95, -402, -283, 237, 226, 305, 207, 175, 386, 298, 50, -224, -23, 60, -353, 98, 96, 340, -143, -49, 240, 291, 257, -368, 467, -15, -282, -362},1138,3682));  // 173
    }

    private static int solve(int[] nums, int lower, int upper) {
        long[] sums= new long[nums.length + 1];
        for (int i = 0; i < nums.length; i ++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countMergeSort(sums, 0, sums.length, lower, upper);
    }
    static int countMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = countMergeSort(sums, start, mid, lower, upper) + countMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i ++, r ++) {
            while (k < end && sums[k] - sums[i] < lower) {
                k ++;
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j ++;
            }
            while (t < end && sums[t] < sums[i]) {
                cache[r] = sums[t];
                r ++;
                t ++;
            }
            cache[r] = sums[i];
            count += j - k;
        }
        if (t - start >= 0) System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}
