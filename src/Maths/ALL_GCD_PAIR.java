/** ALL GCD PAIR
 Problem Description
 Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
 Find and return the original numbers which are used to calculate the GCD array in any order.
 For example, if original numbers are {2, 8, 10} then the given array(N^2 length type) will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.


 Problem Constraints
 1 <= N <= 10000
 1 <= A[i] <= 1e9



 Input Format
 The first and only argument given is the integer array A.


 Output Format
 Find and return the original numbers which are used to calculate the GCD array in any order.


 Example Input
 Input 1:
 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
 Input 2:
 A = [5 5 5 15 ]



 Example Output
 Output 1:
 [2, 8, 10]
 Output 2:
 [5, 15]
 *
 */

package Maths;

import java.util.*;

public class ALL_GCD_PAIR {
    public static void main(String[] args) {
//        int[] A = {2, 2, 2, 2, 8, 2, 2, 2, 10};
//        int[] A = {46, 1, 2, 1, 1, 1, 5, 45, 1, 1, 2, 5, 1, 40, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1 };
        int[] A = {1, 299, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 503, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 866, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 714, 2, 1, 17, 2, 6, 2, 34, 1, 14, 1, 2, 1, 6, 21, 2, 6, 3, 2, 1, 1, 6, 1, 1, 2, 2, 622, 1, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 131, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 131, 1, 1, 1, 1, 1, 1, 1, 17, 1, 1, 187, 1, 11, 1, 17, 11, 1, 1, 1, 1, 1, 11, 1, 11, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 256, 4, 4, 8, 1, 2, 1, 4, 1, 16, 1, 2, 8, 1, 4, 1, 1, 2, 1, 1, 2, 6, 2, 1, 11, 4, 396, 4, 4, 11, 2, 1, 4, 1, 36, 99, 2, 396, 3, 4, 1, 1, 18, 1, 1, 2, 2, 2, 1, 1, 4, 4, 596, 4, 1, 2, 1, 4, 1, 4, 1, 2, 4, 1, 4, 1, 1, 2, 1, 1, 2, 34, 2, 1, 17, 8, 4, 4, 136, 1, 2, 1, 4, 1, 8, 1, 2, 8, 1, 4, 1, 1, 2, 1, 1, 1, 1, 1, 1, 11, 1, 11, 1, 1, 407, 1, 1, 1, 1, 1, 11, 37, 11, 1, 1, 1, 1, 1, 1, 1, 2, 14, 2, 1, 1, 2, 2, 2, 2, 1, 994, 1, 2, 1, 2, 7, 2, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 521, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 4, 4, 4, 4, 1, 2, 1, 692, 1, 4, 1, 2, 4, 1, 4, 1, 1, 2, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 713, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6, 2, 1, 1, 16, 36, 4, 8, 1, 2, 1, 4, 1, 720, 9, 2, 72, 3, 4, 1, 5, 18, 1, 1, 1, 21, 1, 1, 11, 1, 99, 1, 1, 11, 7, 1, 1, 1, 9, 693, 1, 99, 3, 1, 1, 1, 9, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 37, 2, 1, 2, 1, 2, 1, 74, 2, 1, 2, 1, 1, 2, 1, 1, 2, 6, 2, 1, 11, 8, 396, 4, 8, 11, 2, 1, 4, 1, 72, 99, 2, 792, 3, 4, 1, 1, 18, 1, 1, 1, 3, 1, 131, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 3, 393, 1, 1, 1, 3, 1, 1, 2, 2, 2, 1, 1, 4, 4, 4, 4, 1, 2, 1, 4, 1, 4, 1, 2, 4, 1, 556, 1, 139, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 103, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 139, 1, 1, 695, 1, 1, 1, 2, 6, 2, 1, 1, 2, 18, 2, 2, 1, 2, 1, 2, 1, 18, 9, 2, 18, 3, 2, 1, 1, 738};
        int[] res = solve(A);
        for (int i=0; i< res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
    public static int[] solve(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        reverse(A);
        int[] res = new int[(int)Math.sqrt(len)];
        res[0] = A[0];
        int l = 1;
        for(int i =1; i< len && l < (int)Math.sqrt(len); i++){
            if(A[i] != -1) {
                res[l++] = A[i];
                printArray(res);
                for (int j = 0; j < i; j++) {
                    int gcd = __gcd(A[j], A[i]);
                    System.out.println("GCD of "+A[j]+" and "+A[i]+" is "+gcd);
                    replaceValue(A, gcd);
                }
                printArray(A);
            }
        }

        Arrays.sort(res);
        return res;
    }
    static void replaceValue(int[] A, int x){
        int counter = 0;
        for(int i = A.length-1; i>=0; i--){
            if(A[i] == x){
                A[i] = -1;
                counter++;
            }
            if(counter >= 2) break;
        }
    }

    static void printArray(int[] A){
        int n = A.length;
        for(int i=0; i< n; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
    public static void reverse(int[] input)
    {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++){
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }

    static int __gcd(int a, int b) {
        if (b == 0)
            return a;
        return __gcd(b, a % b);
    }
}
