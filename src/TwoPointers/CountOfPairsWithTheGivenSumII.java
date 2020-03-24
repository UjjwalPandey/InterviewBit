/*  COUNT OF PAIRS WITH THE GIVEN SUM

    Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] )
    such that i != j have sum equal to B.

    Input Format
        The first argument given is the integer array A.
        The second argument given is integer B.
    Output Format
        Return the number of pairs for which sum is equal to B  modulo (10^9+7).

    Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    For Example
        Input 1:
            A = [1, 1, 1, 2, 3]
            B = 4
        Output 1:
            3

        Input 2:
            A = [1, 2, 2, 3, 4]
            B = 5
        Output 2:
            3

 */
package TwoPointers;

public class CountOfPairsWithTheGivenSumII {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 3};
        int B = 4;
        System.out.println(getPairs(A,B));
    }

    private static int getPairs(int[] A, int B) {
        long ans = 0;
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < j) {
            if (A[i] + A[j] < B)
                i++;

            else if (A[i] + A[j] > B)
                j--;

            else {

                int x = A[i], xx = i;
                while ((i < j ) && (A[i] == x))
                    i++;

                int y = A[j], yy = j;
                while ((j >= i )&& (A[j] == y))
                    j--;

                if (x == y){
                    long temp = i - xx + yy - j - 1;
                    ans += (temp * (temp + 1)) / 2;
                }
                else
                    ans += (i - xx) * (yy - j);
            }
        }
        return (int)(ans%1000000007);
    }

}
