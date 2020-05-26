/*
    Flip Array

    Problem Description

    Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

    Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.



    Problem Constraints

    1 <= length of(A) <= 100

    Sum of all the elements will not exceed 10,000.



    Input Format

    First and only argument is an integer array A.


    Output Format

    Return an integer denoting the minimum number of elements whose sign needs to be flipped.


    Example Input

    Input 1:

     A = [15, 10, 6]

    Input 2:

     A = [14, 10, 4]



    Example Output

    Output 1:

     1

    Output 2:

     1



    Example Explanation

    Explanation 1:

     Here, we will flip the sign of 15 and the resultant sum will be 1.

    Explanation 2:

     Here, we will flip the sign of 14 and the resultant sum will be 0.
     Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 */
package DP;


public class FlipArray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{14, 10, 4})); // 1
        System.out.println(solve(new int[]{14, 10, 4, 8, 12}));  // 2
        System.out.println(solve(new int[]{15, 10, 6}));  // 1
        System.out.println(solve(new int[]{1, 4, 12, 3, 8, 1, 1, 9, 1, 8, 5, 11, 7, 7, 12, 4, 11, 3, 11, 12, 10, 6, 3, 10, 1, 5, 9, 2, 9, 3, 2, 10, 6, 5, 12, 5, 10, 4, 2, 10, 12, 10, 12, 10, 8, 4, 5, 6, 10, 7, 6, 11, 12, 12, 9, 5, 4, 9, 6, 4, 12, 7, 1, 5, 12, 5, 10, 1, 12, 3, 2, 3, 4, 2, 12, 12, 5, 9}));  // 24
        System.out.println(solve(new int[]{11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3 }));  // 27
    }

    // Find a subset with sum = S/2 with minimum element possible
    public static int solve(final int[] A)  {
        int[] a = new int[A.length];
        System.arraycopy(A, 0, a, 0, a.length);
        int sum = 0;
        for(int x:a) sum+=x;

        int[][] dp = new int[sum/2+1][a.length+1];

        for(int i=0;i<=a.length;i++) {
            dp[0][i] = 0;
        }
        for(int i=1;i<=sum/2;i++){
            dp[i][0] = 1000000;
        }
        for(int i=1;i<=sum/2;i++){
            for(int j=1;j<=a.length;j++){
                dp[i][j] = dp[i][j-1];
                if(i>=a[j-1]) {
                    if(dp[i][j] > dp[i-a[j-1]][j-1] + 1) {
                        dp[i][j] = dp[i-a[j-1]][j-1]+1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<=sum/2;i++){
            if(dp[i][a.length] != 1000000){
                max=i;
            }
        }
        return dp[max][a.length];
    }
}
