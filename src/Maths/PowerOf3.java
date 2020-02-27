/*
    Given a positive integer A.
    Return an array of minimum length whose elements represent the powers of 3 and the sum of all the elements is equal to A.
    NOTE: If A cannot be represented as the sum of powers of 3, then return an array containing only -1.

    Problem Constraints
    1 <= A <= 109

    Input Format
        Single argument is an integer A.

    Output Format
        Return an array of minimum length of powers of 3 whose elements sums to A.

    Example Input
        Input 1:
            13
        Input 2:
             3

    Example Output
        Output 1:
            [ 1, 3, 9]
        Output 2:
            [ 3 ]



    Example Explanation
    Explanation 1:
    30 = 1, 31 = 3, 32 = 9.
    Also, 1 + 3 + 9 = 13. Here A = 13 which can be represented as the sum of 1, 3 and 9.
 */

package Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerOf3 {
    public static void main(String[] args) {
        int A = 1000431;
        int B = 243;
        int C = 244;
        int D = 162;
        int[] result1 = solve(A);
        for(int x: result1) System.out.print(x+"  ");
        System.out.println();
        int[] result2 = solve(B);
        for(int x: result2) System.out.print(x+"  ");
        System.out.println();
        int[] result3 = solve(C);
        for(int x: result3) System.out.print(x+"  ");
        System.out.println();
        int[] result4 = solve(D);
        for(int x: result4) System.out.print(x+"  ");
        System.out.println();


    }

    public static int[] solve(int A) {
        if(A < 3) return new int[]{-1};
        int pow3 = (int) (Math.log(A)/Math.log(3));
        int[] pow3List = new int[pow3 +2];
        for(int i = 0; i <= pow3+1; i++){
            pow3List[i] = (int)Math.pow(3,i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(A > 0){
            if(Arrays.binarySearch(pow3List, A) > 0){
                res.add(A);
                A =0;
            }else{
                int log = (int)(Math.log(A)/Math.log(3));
                A -= pow3List[log];
                res.add(pow3List[log]);
            }
        }

        int[] result = new int[res.size()];
        for(int i=0; i< result.length; i++){
            result[i]= res.get(i);
        }
        return result;
    }
}
