/*  COUNT OF PAIRS WITH THE GIVEN SUM

    Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] )
    such that i != j have sum equal to B.

    Input Format
        The first argument given is the integer array A.
        The second argument given is integer B.
    Output Format
        Return the number of pairs for which sum is equal to B.

    Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    For Example
        Input 1:
            A = [1, 2, 3, 4, 5]
            B = 5
        Output 1:
            2

        Input 2:
            A = [5, 10, 20, 100, 105]
            B = 110
        Output 2:
            2

 */
package TwoPointers;

public class CountOfPairsWithTheGivenSum {
    public static void main(String[] args) {
        int[] A = {5, 10, 20, 100, 105};
        int B = 110;
        System.out.println(getPairs(A,B));
    }

    private static int getPairs(int[] A, int B) {
        int count =0;
        int l =0, r = A.length-1;
        while (l < r){
            int sum = A[l]+A[r];
            if(sum == B) {
                count++;
                l++;
                r--;
            }else if(sum > B) {
                r--;
            }else{
                l++;
            }
        }
        return count;
    }

}
