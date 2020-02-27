/*  Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
    Since the answer may be large, return the answer modulo (109 + 7).
        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 109
        1 <= B <= 106

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

        Example Input
        Input 1:
         A = [1, 2, 3, 4, 5]
         B = 2
        Input 2:
         A = [5, 17, 100, 11]
         B = 28

        Example Output
        Output 1:
         4
        Output 2:
         1

        Example Explanation
        Explanation 1:
         All pairs which are divisible by 2 are (1,3),(1,5),(2,4),(3,5).
         So total 4 pairs.
 */
package Array;

import java.util.HashMap;

public class CountPairsInArraySumDivisibleByGivenNumber {
    public static void main(String[] args) {
        int[] A= {1, 2, 3, 4, 5};
        int B = 2;
        int[] C= {5, 17, 11, 100};
        int D = 28;
        System.out.println(solve_O_N(A,B));
        System.out.println(solve_O_N(C,D));
        System.out.println(solve_O_N2(A,B));
        System.out.println(solve_O_N2(C,D));
    }

    public static int solve_O_N(int[] A, int B) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int value : A) {
            int remainder = value % B;
            int complementaryNum = B - remainder;
            complementaryNum = (complementaryNum == B) ? 0 : complementaryNum;
            count += hm.getOrDefault(complementaryNum, 0);
            int incrementRemainderCount = hm.getOrDefault(remainder, 0);
            hm.put(remainder, ++incrementRemainderCount);
        }
        return  count%1000000007;
    }
    public static int solve_O_N2(int[] A, int B) {
        int len = A.length, count = 0;
        for(int i=0; i< len; i++){
            for(int j = i+1; j< len; j++){
                if((A[i]+A[j])%B == 0){
                    count = (count+1)%1000000007;
                }
            }
        }
        return count%1000000007;
    }
}
